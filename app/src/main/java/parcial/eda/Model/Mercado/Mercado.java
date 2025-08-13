package parcial.eda.Model.Mercado;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;
import parcial.eda.Model.Usuario.Usuario;
import parcial.eda.Services.ApiManager;

public class Mercado {

    // Lista de criptomonedas
    public static List<Criptomoneda> criptomonedas = ApiManager.consumirApi();

    // Lista global de transacciones
    public static Queue<Transaccion> libroOrdenesMercado = new LinkedList<>();

    public static void comprar(Usuario usuario, Criptomoneda moneda, int cantidadCripto) {
        libroOrdenesMercado.add(new Transaccion("Compra", usuario, moneda, cantidadCripto));
    }

    public static void vender(Usuario usuario, Criptomoneda moneda, int cantidadCripto) {
        libroOrdenesMercado.add(new Transaccion("Venta", usuario, moneda, cantidadCripto));
    }

}
