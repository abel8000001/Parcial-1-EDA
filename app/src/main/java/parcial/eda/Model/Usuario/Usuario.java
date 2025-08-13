package parcial.eda.Model.Usuario;

import java.util.Stack;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;

public class Usuario {
    private String nombre;
    private double saldo;
    Bag<Criptomoneda> portafolio;
    Stack<Transaccion> historial;

    public Usuario(String nombre) {
        this.nombre = nombre;
        saldo = 100000000;
        portafolio = new HashBag<>();
        historial = new Stack<>();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public Bag<Criptomoneda> getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(Bag<Criptomoneda> portafolio) {
        this.portafolio = portafolio;
    }

    public Stack<Transaccion> getHistorial() {
        return historial;
    }

    public double getValorTotalPortafolio() {
        double total = 0;
        for (Criptomoneda c : portafolio) {
            total += c.getPrice_usdAsDouble();
        }
        return total;
    }

    public void addEntradaHistorial(Transaccion transaccion) {
        historial.push(transaccion);
    }

}
