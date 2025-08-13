package parcial.eda.Services;

public class Utilidades {
    // Metodo para hacer mas facil la generacion de numeros aleatorios dentro de un rango
    public static double randomEnRango(double min, double max) {
        return min + (double)(Math.random() * (max - min + 1));
    }

    // Conversiones de divisas
    public static double usdAPeso(double usd) {
        return usd * 4000;
    }

    public static double pesoAUsd(double pesos) {
        return pesos / 4000;
    }
}

