package parcial.eda.Model.Transaccion;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Usuario.Usuario;

public class Transaccion {

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
        } catch (Exception e) {
            this.valorTotal = -1; // Valor de error
            this.estado = "Error";
            System.out.println("Error al crear transacción: " + e.getMessage());
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        try {
            this.tipo = tipo;
        } catch (Exception e) {
            System.out.println("Error al establecer tipo de transacción: " + e.getMessage());
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
        } catch (Exception e) {
            System.out.println("Error al establecer estado de transacción: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        try {
            return "Transaccion{" +
                    "Tipo ='" + tipo + '\'' +
                    ", Usuario ='" + usuario.getNombre() + '\'' +
                    ", Criptomoneda ='" + criptomoneda.getName() + '\'' +
                    ", Cantidad ='" + cantidadCripto + '\'' +
                    ", Estado ='" + estado + '\'' +
                    '}';
        } catch (Exception e) {
            return "Transaccion{Error al mostrar datos}";
        }
    }
}
