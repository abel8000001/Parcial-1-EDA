package parcial.eda.Model.Usuario;

import java.util.Stack;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;

public class Usuario {

    private static int id;
    private String nombre;
    private double saldo;
    Bag<Criptomoneda> portafolio;
    Stack<Transaccion> historial;

    public Usuario (String nombre){
        this.nombre = nombre;
        saldo = 0;
        id++;
        portafolio = new HashBag<>();
        historial = new Stack<>();
    }

    public void consignar(double cantidad){
        if (cantidad < 0) {
            System.out.println("Cantidad a consignar no puede ser menor que 0");
            return;
        }
        saldo += cantidad;
    }

    public void retirar(double cantidad){
        if (cantidad < 0) {
            System.out.println("Cantidad a retirar no puede ser menor que 0");
            return;
        }

        if(saldo < cantidad){
            System.out.println("Fondos insuficientes");
        }

        saldo -= cantidad;
    }

    public double getSaldo(){
        return saldo;
    }

    public String getNombre(){
        return nombre;
    }

}
