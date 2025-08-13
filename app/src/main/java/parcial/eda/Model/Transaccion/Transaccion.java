package parcial.eda.Model.Transaccion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Usuario.Usuario;

public class Transaccion {

    private static final Logger logger = LogManager.getLogger(Transaccion.class);

    private String tipo;
    private Usuario usuario;
    private Criptomoneda criptomoneda;
    private int cantidadCripto;
    private double valorTotal;
    private String estado;

    public Transaccion(String tipo, Usuario usuario, Criptomoneda criptomoneda, int cantidadCripto) {
        try {
            this.tipo = tipo;
            this.usuario = usuario;
            this.criptomoneda = criptomoneda;
            this.cantidadCripto = cantidadCripto;
            this.valorTotal = criptomoneda.getPrice_usdAsDouble() * cantidadCripto;
            this.estado = "Pendiente";
            logger.info("Transacción creada: Tipo=" + tipo +
                        ", Usuario=" + usuario.getNombre() +
                        ", Criptomoneda=" + criptomoneda.getName() +
                        ", Cantidad=" + cantidadCripto +
                        ", ValorTotal=" + valorTotal +
                        ", Estado=Pendiente");
        } catch (Exception e) {
            this.valorTotal = -1; // Valor de error
            this.estado = "Error";
            logger.error("Error al crear transacción", e);
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        try {
            this.tipo = tipo;
            logger.info("Tipo de transacción actualizado a: " + tipo);
        } catch (Exception e) {
            logger.error("Error al establecer tipo de transacción", e);
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Criptomoneda getCriptomoneda() {
        return criptomoneda;
    }

    public int getCantidadCripto() {
        return cantidadCripto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        try {
            this.estado = estado;
            logger.info("Estado de transacción actualizado a: " + estado);
        } catch (Exception e) {
            logger.error("Error al establecer estado de transacción", e);
        }
    }

    @Override
    public String toString() {
        try {
            String datos = "Transaccion{" +
                    "Tipo='" + tipo + '\'' +
                    ", Usuario='" + usuario.getNombre() + '\'' +
                    ", Criptomoneda='" + criptomoneda.getName() + '\'' +
                    ", Cantidad='" + cantidadCripto + '\'' +
                    ", Estado='" + estado + '\'' +
                    '}';
            logger.info("Generando representación de transacción: " + datos);
            return datos;
        } catch (Exception e) {
            logger.error("Error al generar toString de Transaccion", e);
            return "Transaccion{Error al mostrar datos}";
        }
    }
}
