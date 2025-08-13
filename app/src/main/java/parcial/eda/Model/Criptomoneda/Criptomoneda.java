package parcial.eda.Model.Criptomoneda;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Criptomoneda {

    private static final Logger logger = LogManager.getLogger(Criptomoneda.class);

    private String id;
    private String symbol;
    private String name;
    private String price_usd;

    // Getters y setters con control de errores
    public String getId() {
        return id;
    }

    public void setId(String id) {
        try {
            this.id = id;
            logger.info("ID de criptomoneda establecido: " + id);
        } catch (Exception e) {
            logger.error("Error al establecer ID de criptomoneda", e);
            this.id = null;
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        try {
            this.symbol = symbol;
            logger.info("Símbolo de criptomoneda establecido: " + symbol);
        } catch (Exception e) {
            logger.error("Error al establecer símbolo de criptomoneda", e);
            this.symbol = null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            this.name = name;
            logger.info("Nombre de criptomoneda establecido: " + name);
        } catch (Exception e) {
            logger.error("Error al establecer nombre de criptomoneda", e);
            this.name = null;
        }
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public double getPrice_usdAsDouble() {
        try {
            double valor = Double.parseDouble(price_usd);
            logger.info("Conversión exitosa de precio_usd a double: " + valor);
            return valor;
        } catch (Exception e) {
            logger.error("Error al convertir precio_usd a double", e);
            return -1; // Valor de error
        }
    }

    public void setPrice_usd(String price_usd) {
        try {
            this.price_usd = price_usd;
            logger.info("Precio en USD establecido: " + price_usd);
        } catch (Exception e) {
            logger.error("Error al establecer precio en USD", e);
            this.price_usd = "0";
        }
    }

    @Override
    public String toString() {
        try {
            String datos = "Criptomoneda{" +
                    "id='" + id + '\'' +
                    ", symbol='" + symbol + '\'' +
                    ", name='" + name + '\'' +
                    ", price_usd='" + price_usd + '\'' +
                    '}';
            logger.info("Generando representación de criptomoneda: " + datos);
            return datos;
        } catch (Exception e) {
            logger.error("Error al generar toString de Criptomoneda", e);
            return "Criptomoneda{Error al mostrar datos}";
        }
    }
}
