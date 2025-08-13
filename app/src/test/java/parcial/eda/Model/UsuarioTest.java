package parcial.eda.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;
import parcial.eda.Model.Usuario.Usuario;

class UsuarioTest {

    @Test
    void testUsuarioCreation() {
        Usuario u = new Usuario("Juan");
        assertEquals("Juan", u.getNombre());
        assertEquals(100000000, u.getSaldo());
        assertNotNull(u.getPortafolio());
        assertNotNull(u.getHistorial());
    }

    @Test
    void testSetAndGetSaldo() {
        Usuario u = new Usuario("Ana");
        u.setSaldo(5000);
        assertEquals(5000, u.getSaldo());
    }

    @Test
    void testSetAndGetPortafolio() {
        Usuario u = new Usuario("Ana");
        assertNotNull(u.getPortafolio());
    }

    @Test
    void testAddEntradaHistorial() {
        Usuario u = new Usuario("Ana");
        Criptomoneda c = new Criptomoneda();
        c.setName("BTC");
        Transaccion t = new Transaccion("Compra", u, c, 1);
        u.addEntradaHistorial(t);
        assertFalse(u.getHistorial().isEmpty());
    }
}
