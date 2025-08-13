package parcial.eda.Model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Mercado.Mercado;
import parcial.eda.Model.Usuario.Usuario;
import parcial.eda.Services.ProcesadorTransacciones;

class ProcesadorTransaccionesTest {

    @Test
    void testProcesarTransacciones() {
        Usuario u = new Usuario("Test");
        Criptomoneda c = new Criptomoneda();
        c.setName("BTC");
        c.setPrice_usd("1");
        Mercado.comprar(u, c, 1);
        ProcesadorTransacciones.procesarTransacciones();
        assertFalse(u.getHistorial().isEmpty());
    }
}
