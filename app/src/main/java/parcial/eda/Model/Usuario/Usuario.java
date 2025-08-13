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
        try {
            this.nombre = nombre;
            this.saldo = 100000000;
            this.portafolio = new HashBag<>();
            this.historial = new Stack<>();
        } catch (Exception e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
            this.portafolio = new HashBag<>();
            this.historial = new Stack<>();
            this.saldo = 0;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        try {
            this.saldo = saldo;
        } catch (Exception e) {
            System.out.println("Error al establecer saldo: " + e.getMessage());
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Bag<Criptomoneda> getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(Bag<Criptomoneda> portafolio) {
        try {
            this.portafolio = portafolio;
        } catch (Exception e) {
            System.out.println("Error al establecer portafolio: " + e.getMessage());
        }
    }

    public Stack<Transaccion> getHistorial() {
        return historial;
    }

    public double getValorTotalPortafolio() {
        try {
            double total = 0;
            for (Criptomoneda c : portafolio) {
                total += c.getPrice_usdAsDouble();
            }
            return total;
        } catch (Exception e) {
            System.out.println("Error al calcular valor total del portafolio: " + e.getMessage());
            return -1; // Valor de error
        }
    }

    public void addEntradaHistorial(Transaccion transaccion) {
        try {
            historial.push(transaccion);
        } catch (Exception e) {
            System.out.println("Error al agregar transacción al historial: " + e.getMessage());
        }
    }
}
