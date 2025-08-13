package parcial.eda.Services;

import java.util.List;
import java.util.Map;

import parcial.eda.Model.Transaccion.Transaccion;

public class ReporteUsuario {
    private String nombre;
    private double saldoUsd;
    private double valorTotalPortafolio;
    private Map<String, Integer> portafolio; // nombreCripto -> cantidad
    private List<Transaccion> historico; // Lista de transacciones como String

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldoUsd() {
        return saldoUsd;
    }

    public void setSaldoUsd(double saldoUsd) {
        this.saldoUsd = saldoUsd;
    }

    public double getValorTotalPortafolio() {
        return valorTotalPortafolio;
    }
    
    public void setValorTotalPortafolio(double valorTotalPortafolio) {
        this.valorTotalPortafolio = valorTotalPortafolio;
    }

    public Map<String, Integer> getPortafolio() {
        return portafolio;
    }

    public void setPortafolio(Map<String, Integer> portafolio) {
        this.portafolio = portafolio;
    }

    public List<Transaccion> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Transaccion> historico) {
        this.historico = historico;
    }
}
