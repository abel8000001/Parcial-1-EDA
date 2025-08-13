package parcial.eda.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Model.Mercado.Mercado;
import parcial.eda.Model.Usuario.Usuario;

class MercadoTest {

    @Test
    void testComprarYVender() {
        Usuario u = new Usuario("Carlos");
        Criptomoneda c = new Criptomoneda();
        c.setName("BTC");
        c.setPrice_usd("100");
        int cantidad = 2;

        int sizeBefore = Mercado.libroOrdenesMercado.size();
        Mercado.comprar(u, c, cantidad);
        assertEquals(sizeBefore + 1, Mercado.libroOrdenesMercado.size());

        sizeBefore = Mercado.libroOrdenesMercado.size();
        Mercado.vender(u, c, cantidad);
        assertEquals(sizeBefore + 1, Mercado.libroOrdenesMercado.size());
    }
}
