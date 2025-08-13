package parcial.eda.Services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Mercado.Mercado;
import parcial.eda.Model.Transaccion.Transaccion;
import parcial.eda.Model.Usuario.Usuario;

public class ProcesadorTransacciones {

    private static final Logger logger = LogManager.getLogger(ProcesadorTransacciones.class);

    // Aprueba o desaprueba cada una de las transacciones que se hicieron en el turno
    public static void procesarTransacciones() {
        try {
            logger.info("Iniciando procesamiento de transacciones. Total en cola: " + Mercado.libroOrdenesMercado.size());

            Transaccion transaccionActual;
            Usuario usuarioActual;
            Criptomoneda criptomonedaActual;
            int cantidadCriptoATransferir;

            // Itera y va consumiendo todas las transacciones
            while (!Mercado.libroOrdenesMercado.isEmpty()) {
                try {
                    transaccionActual = Mercado.libroOrdenesMercado.poll();
                    logger.info("Procesando transacción: " + transaccionActual);

                    usuarioActual = transaccionActual.getUsuario();
                    criptomonedaActual = transaccionActual.getCriptomoneda();
                    cantidadCriptoATransferir = transaccionActual.getCantidadCripto();

                    if ("Compra".equals(transaccionActual.getTipo())) {
                        logger.info("Tipo de transacción: Compra para usuario: " + usuarioActual.getNombre());

                        if (Utilidades.pesoAUsd(usuarioActual.getSaldo()) < transaccionActual.getValorTotal()) {
                            transaccionActual.setEstado("Rechazado");
                            usuarioActual.addEntradaHistorial(transaccionActual);
                            logger.info("Compra rechazada por saldo insuficiente. Usuario: " + usuarioActual.getNombre());
                            continue;
                        }

                        transaccionActual.setEstado("Aprobado");
                        usuarioActual.setSaldo(
                            usuarioActual.getSaldo() - Utilidades.usdAPeso(transaccionActual.getValorTotal())
                        );
                        usuarioActual.getPortafolio().add(criptomonedaActual, cantidadCriptoATransferir);
                        usuarioActual.addEntradaHistorial(transaccionActual);
                        logger.info("Compra aprobada. Usuario: " + usuarioActual.getNombre() + ", Cripto: " + criptomonedaActual.getName());

                    } else if ("Venta".equals(transaccionActual.getTipo())) {
                        logger.info("Tipo de transacción: Venta para usuario: " + usuarioActual.getNombre());

                        if (usuarioActual.getPortafolio().getCount(criptomonedaActual) < cantidadCriptoATransferir) {
                            transaccionActual.setEstado("Rechazado");
                            usuarioActual.addEntradaHistorial(transaccionActual);
                            logger.info("Venta rechazada por cantidad insuficiente en portafolio. Usuario: " + usuarioActual.getNombre());
                            continue;
                        }

                        transaccionActual.setEstado("Aprobado");
                        usuarioActual.getPortafolio().remove(criptomonedaActual, cantidadCriptoATransferir);
                        usuarioActual.setSaldo(
                            usuarioActual.getSaldo() + Utilidades.usdAPeso(transaccionActual.getValorTotal())
                        );
                        usuarioActual.addEntradaHistorial(transaccionActual);
                        logger.info("Venta aprobada. Usuario: " + usuarioActual.getNombre() + ", Cripto: " + criptomonedaActual.getName());
                    }
                } catch (Exception e) {
                    logger.error("Error procesando una transacción individual.", e);
                    System.out.println("Error procesando una transacción: " + e.getMessage());
                }
            }

            logger.info("Procesamiento de transacciones finalizado.");
        } catch (Exception e) {
            logger.error("Error general en el procesamiento de transacciones.", e);
            System.out.println("Error general en el procesamiento de transacciones: " + e.getMessage());
        }
    }
}
