package parcial.eda.Services;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Mercado.Mercado;
import parcial.eda.Model.Transaccion.Transaccion;
import parcial.eda.Model.Usuario.Usuario;

public class ProcesadorTransacciones {

    // Aprueba o desaprueba cada una de las transacciones que se hicieron en el turno
    public static void procesarTransacciones() {
        Transaccion transaccionActual;
        Usuario usuarioActual;
        Criptomoneda criptomonedaActual;
        int cantidadCriptoATransferir;
        double valorTotalCriptomonedas;

        while (!Mercado.libroOrdenesMercado.isEmpty()) {
            transaccionActual = Mercado.libroOrdenesMercado.poll();
            usuarioActual = transaccionActual.getUsuario();
            criptomonedaActual = transaccionActual.getCriptomoneda();
            cantidadCriptoATransferir = transaccionActual.getCantidadCripto();
            valorTotalCriptomonedas = criptomonedaActual.getPrice_usdAsDouble() * cantidadCriptoATransferir;


            if (transaccionActual.getTipo() == "Compra") {

                if (Utilidades.pesoAUsd(usuarioActual.getSaldo()) < valorTotalCriptomonedas) {
                    System.out.println("El usuario " + usuarioActual.getNombre()
                            + " no tiene suficiente saldo para comprar " + cantidadCriptoATransferir + " "
                            + criptomonedaActual.getName());
                    transaccionActual.setEstado("Rechazado");
                    usuarioActual.addEntradaHistorial(transaccionActual);
                }

                transaccionActual.setEstado("Aprobado");
                usuarioActual.setSaldo(usuarioActual.getSaldo() - Utilidades.usdAPeso(valorTotalCriptomonedas));
                usuarioActual.getPortafolio().add(criptomonedaActual, cantidadCriptoATransferir);
                usuarioActual.addEntradaHistorial(transaccionActual);

            } else if (transaccionActual.getTipo() == "Venta") {
                if (usuarioActual.getPortafolio().getCount(criptomonedaActual) < cantidadCriptoATransferir) {
                    System.out.println("El usuario " + usuarioActual.getNombre()
                            + " no tiene suficiente " + criptomonedaActual.getName() + " para vender");
                    transaccionActual.setEstado("Rechazado");
                    usuarioActual.addEntradaHistorial(transaccionActual);
                }

                transaccionActual.setEstado("Aprobado");
                usuarioActual.getPortafolio().remove(criptomonedaActual, cantidadCriptoATransferir);
                usuarioActual.setSaldo(usuarioActual.getSaldo() + Utilidades.usdAPeso(valorTotalCriptomonedas));
                usuarioActual.addEntradaHistorial(transaccionActual);
            }
        }
    }
}
