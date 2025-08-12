package parcial.eda.Services;

public class Utils {
    // Metodo para hacer mas facil la generacion de numeros aleatorios dentro de un rango
    public static double randomInRange(double min, double max) {
        return min + (double)(Math.random() * (max - min + 1));
    }
}

