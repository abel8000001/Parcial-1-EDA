package parcial.eda.Model.Mercado;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;
import parcial.eda.Model.Usuario.Usuario;
import parcial.eda.Services.ApiManager;

public class Mercado {

    private static final Logger logger = LogManager.getLogger(Mercado.class);

    // Lista de criptomonedas
    public static List<Criptomoneda> criptomonedas;
    static {
        try {
            logger.info("Cargando lista de criptomonedas desde la API...");
            criptomonedas = ApiManager.consumirApi();
            logger.info("Lista de criptomonedas cargada correctamente. Total: " + criptomonedas.size());
        } catch (Exception e) {
            criptomonedas = new LinkedList<>();
            logger.error("Error al cargar criptomonedas desde la API", e);
        }
    }

    // Lista global de transacciones
    public static Queue<Transaccion> libroOrdenesMercado = new LinkedList<>();

    public static void comprar(Usuario usuario, Criptomoneda moneda, int cantidadCripto) {
        try {
            logger.info("Registrando orden de compra: Usuario=" + usuario.getNombre() +
                        ", Criptomoneda=" + moneda.getName() +
                        ", Cantidad=" + cantidadCripto);
            libroOrdenesMercado.add(new Transaccion("Compra", usuario, moneda, cantidadCripto));
            logger.info("Orden de compra registrada con éxito");
        } catch (Exception e) {
            logger.error("Error al registrar orden de compra para usuario " + usuario.getNombre(), e);
        }
    }

    public static void vender(Usuario usuario, Criptomoneda moneda, int cantidadCripto) {
        try {
            logger.info("Registrando orden de venta: Usuario=" + usuario.getNombre() +
                        ", Criptomoneda=" + moneda.getName() +
                        ", Cantidad=" + cantidadCripto);
            libroOrdenesMercado.add(new Transaccion("Venta", usuario, moneda, cantidadCripto));
            logger.info("Orden de venta registrada con éxito");
        } catch (Exception e) {
            logger.error("Error al registrar orden de venta para usuario " + usuario.getNombre(), e);
        }
    }
}
