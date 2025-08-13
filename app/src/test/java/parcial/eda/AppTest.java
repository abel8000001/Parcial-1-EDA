package parcial.eda;

import org.junit.jupiter.api.*;
import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;
import parcial.eda.Model.Usuario.Usuario;

import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Queue;

import com.google.gson.*;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private Queue<Usuario> usuarios;

    @BeforeEach
    void setUp() {
        usuarios = new LinkedList<>();

        // Crear un usuario con portafolio y transacción
        Usuario u = new Usuario("usuarioPrueba");

        // Configurar una criptomoneda
        Criptomoneda cripto = new Criptomoneda();
        cripto.setName("Bitcoin");
        cripto.setPrice_usd("50000");

        // Agregar cripto al portafolio
        u.getPortafolio().add(cripto, 2);

        // Agregar saldo
        u.setSaldo(200000); // pesos (para test de Utilidades)

        // Crear transacción
        Transaccion t = new Transaccion("Compra", u, cripto, 2);
        t.setEstado("Aprobado");
        u.getHistorial().push(t);

        usuarios.add(u);
    }

    @Test
    @DisplayName("Debe generar un archivo JSON con datos correctos")
    void testGenerarReporteUsuariosJSON() throws Exception {
        // Ejecutar
        App.generarReporteUsuariosJSON(usuarios);

        File archivo = new File("reporteUsuarios.json");
        assertTrue(archivo.exists(), "El archivo JSON debe existir");

        // Leer el contenido y validar campos
        JsonArray jsonArray;
        try (FileReader reader = new FileReader(archivo)) {
            jsonArray = JsonParser.parseReader(reader).getAsJsonArray();
        }

        assertEquals(1, jsonArray.size(), "Debe haber 1 usuario en el reporte");

        JsonObject usuarioJson = jsonArray.get(0).getAsJsonObject();
        assertEquals("usuarioPrueba", usuarioJson.get("nombre").getAsString());

        // Validar portafolio
        JsonObject portafolio = usuarioJson.get("portafolio").getAsJsonObject();
        assertTrue(portafolio.has("Bitcoin"));
        assertEquals(2, portafolio.get("Bitcoin").getAsInt());

        // Validar histórico de transacciones
        JsonArray historico = usuarioJson.get("historico").getAsJsonArray();
        assertEquals(1, historico.size());
        JsonObject transaccionJson = historico.get(0).getAsJsonObject();
        assertEquals("Compra", transaccionJson.get("tipo").getAsString());
        assertEquals("Aprobado", transaccionJson.get("estado").getAsString());
        assertEquals(2, transaccionJson.get("cantidadCripto").getAsInt());
    }

    @AfterEach
    void cleanUp() {
        File archivo = new File("reporteUsuarios.json");
        if (archivo.exists()) {
            archivo.delete();
        }
    }
}
