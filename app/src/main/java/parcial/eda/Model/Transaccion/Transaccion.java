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

    public Transaccion(String tipo, Usuario usuario, Criptomoneda criptomoneda, int cantidadCripto){
        this.tipo = tipo;
        this.usuario = usuario;
        this.criptomoneda = criptomoneda;
        this.cantidadCripto = cantidadCripto;
        valorTotal = criptomoneda.getPrice_usdAsDouble() * cantidadCripto;
        estado = "Pendiente";
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "Tipo ='" + tipo + '\'' +
                ", Usuario ='" + usuario.getNombre() + '\'' +
                ", Criptomoneda ='" + criptomoneda.getName() + '\'' +
                ", Cantidad ='" + cantidadCripto + '\'' +
                ", Estado ='" + estado + '\'' +
                '}';
    }
}
