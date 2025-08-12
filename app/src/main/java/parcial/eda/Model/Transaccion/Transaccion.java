package parcial.eda.Model.Transaccion;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Usuario.Usuario;

public class Transaccion {

    private Usuario usuario;
    private Criptomoneda criptomoneda;
    private int cantidadCripto;
    private int turno;

    public Transaccion(Usuario usuario, Criptomoneda criptomoneda, int cantidadCripto, int turno){
        this.usuario = usuario;
        this.criptomoneda = criptomoneda;
        this.cantidadCripto = cantidadCripto;
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Transaccion{" +
                "Usuario='" + usuario.getNombre() + '\'' +
                ", Criptomoneda='" + criptomoneda.getName() + '\'' +
                ", Cantidad='" + cantidadCripto + '\'' +
                ", Turno='" + turno + '\'' +
                '}';
    }


}
