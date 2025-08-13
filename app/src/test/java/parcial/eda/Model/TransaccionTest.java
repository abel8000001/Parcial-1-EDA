package parcial.eda.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Transaccion.Transaccion;
import parcial.eda.Model.Usuario.Usuario;

class TransaccionTest {

    @Test
    void testTransaccionCreation() {
        Usuario u = new Usuario("Luis");
        Criptomoneda c = new Criptomoneda();
        c.setName("BTC");
        c.setPrice_usd("100");
        Transaccion t = new Transaccion("Compra", u, c, 2);
        assertEquals("Compra", t.getTipo());
        assertEquals(u, t.getUsuario());
        assertEquals(c, t.getCriptomoneda());
        assertEquals(2, t.getCantidadCripto());
        assertEquals(200, t.getValorTotal(), 0.001);
        assertEquals("Pendiente", t.getEstado());
    }

    @Test
    void testSetTipoAndEstado() {
        Usuario u = new Usuario("Luis");
        Criptomoneda c = new Criptomoneda();
        Transaccion t = new Transaccion("Compra", u, c, 1);
        t.setTipo("Venta");
        t.setEstado("Aprobado");
        assertEquals("Venta", t.getTipo());
        assertEquals("Aprobado", t.getEstado());
    }

    @Test
    void testToString() {
        Usuario u = new Usuario("Luis");
        Criptomoneda c = new Criptomoneda();
        c.setName("BTC");
        Transaccion t = new Transaccion("Compra", u, c, 1);
        assertTrue(t.toString().contains("Transaccion"));
    }
}
