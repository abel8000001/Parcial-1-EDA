package parcial.eda.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import parcial.eda.Services.Utilidades;

class UtilidadesTest {

    @Test
    void testRandomEnRango() {
        double min = 1.0, max = 5.0;
        for (int i = 0; i < 100; i++) {
            double val = Utilidades.randomEnRango(min, max);
            assertTrue(val >= min && val <= max + 1);
        }
    }

    @Test
    void testUsdAPeso() {
        assertEquals(4000, Utilidades.usdAPeso(1), 0.001);
    }

    @Test
    void testPesoAUsd() {
        assertEquals(1, Utilidades.pesoAUsd(4000), 0.001);
    }
}
