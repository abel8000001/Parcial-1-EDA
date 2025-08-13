package parcial.eda.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import parcial.eda.Model.Criptomoneda.Criptomoneda;
import parcial.eda.Services.ApiManager;

class ApiManagerTest {

    @Test
    void testConsumirApi() {
        List<Criptomoneda> lista = ApiManager.consumirApi();
        assertNotNull(lista);
        // Puede estar vacía si no hay conexión, pero nunca debe ser null
    }
}
