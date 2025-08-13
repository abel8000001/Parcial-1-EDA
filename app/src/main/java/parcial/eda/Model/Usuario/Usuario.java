package parcial.eda.Model.Usuario;

import java.util.Stack;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;

public class Usuario {

    private static final Logger logger = LogManager.getLogger(Usuario.class);

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
            logger.info("Usuario creado: Nombre=" + nombre + ", Saldo inicial=" + saldo);
        } catch (Exception e) {
            this.portafolio = new HashBag<>();
            this.historial = new Stack<>();
            this.saldo = 0;
            logger.error("Error al crear usuario con nombre: " + nombre, e);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        try {
            this.saldo = saldo;
            logger.info("Saldo actualizado para usuario " + nombre + ": Nuevo saldo=" + saldo);
        } catch (Exception e) {
            logger.error("Error al establecer saldo para usuario " + nombre, e);
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
            logger.info("Portafolio actualizado para usuario " + nombre);
        } catch (Exception e) {
            logger.error("Error al establecer portafolio para usuario " + nombre, e);
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
            logger.info("Valor total del portafolio para usuario " + nombre + ": " + total);
            return total;
        } catch (Exception e) {
            logger.error("Error al calcular valor total del portafolio para usuario " + nombre, e);
            return -1; // Valor de error
        }
    }

    public void addEntradaHistorial(Transaccion transaccion) {
        try {
            historial.push(transaccion);
            logger.info("Transacción añadida al historial de usuario " + nombre + ": " + transaccion);
        } catch (Exception e) {
            logger.error("Error al agregar transacción al historial para usuario " + nombre, e);
        }
    }
}
