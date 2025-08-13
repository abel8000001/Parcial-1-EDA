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

        // Itera y va consumiendo todas las transacciones
        while (!Mercado.libroOrdenesMercado.isEmpty()) {
            transaccionActual = Mercado.libroOrdenesMercado.poll();
            usuarioActual = transaccionActual.getUsuario();
            criptomonedaActual = transaccionActual.getCriptomoneda();
            cantidadCriptoATransferir = transaccionActual.getCantidadCripto();


            if (transaccionActual.getTipo() == "Compra") {

                if (Utilidades.pesoAUsd(usuarioActual.getSaldo()) < transaccionActual.getValorTotal()) {
                    transaccionActual.setEstado("Rechazado");
                    usuarioActual.addEntradaHistorial(transaccionActual);
                    continue;
                }

                transaccionActual.setEstado("Aprobado");
                usuarioActual.setSaldo(usuarioActual.getSaldo() - Utilidades.usdAPeso(transaccionActual.getValorTotal()));
                usuarioActual.getPortafolio().add(criptomonedaActual, cantidadCriptoATransferir);
                usuarioActual.addEntradaHistorial(transaccionActual);

            } else if (transaccionActual.getTipo() == "Venta") {
                if (usuarioActual.getPortafolio().getCount(criptomonedaActual) < cantidadCriptoATransferir) {
                    transaccionActual.setEstado("Rechazado");
                    usuarioActual.addEntradaHistorial(transaccionActual);
                    continue;
                }

                transaccionActual.setEstado("Aprobado");
                usuarioActual.getPortafolio().remove(criptomonedaActual, cantidadCriptoATransferir);
                usuarioActual.setSaldo(usuarioActual.getSaldo() + Utilidades.usdAPeso(transaccionActual.getValorTotal()));
                usuarioActual.addEntradaHistorial(transaccionActual);
            }
        }
    }
}
