package parcial.eda.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import parcial.eda.Model.Criptomoneda.Criptomoneda;

class CriptomonedaTest {

    @Test
    void testSetAndGetId() {
        Criptomoneda c = new Criptomoneda();
    }

    @Test
    void testSetAndGetSymbol() {
        Criptomoneda c = new Criptomoneda();
    }

    @Test
    void testSetAndGetName() {
        Criptomoneda c = new Criptomoneda();
        c.setName("Bitcoin");
        assertEquals("Bitcoin", c.getName());
    }

    @Test
    void testSetAndGetPriceUsd() {
        Criptomoneda c = new Criptomoneda();
        c.setPrice_usd("123.45");
        assertEquals("123.45", c.getPrice_usd());
        assertEquals(123.45, c.getPrice_usdAsDouble(), 0.001);
    }

    @Test
    void testToString() {
        Criptomoneda c = new Criptomoneda();
        c.setName("Bitcoin");
        c.setPrice_usd("1000");
        assertTrue(c.toString().contains("Bitcoin"));
    }
}