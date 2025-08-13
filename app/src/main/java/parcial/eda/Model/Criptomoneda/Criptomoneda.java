package parcial.eda.Model.Criptomoneda;

public class Criptomoneda {
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
        } catch (Exception e) {
            this.id = null;
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        try {
            this.symbol = symbol;
        } catch (Exception e) {
            this.symbol = null;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            this.name = name;
        } catch (Exception e) {
            this.name = null;
        }
    }

    public String getPrice_usd() {
        return price_usd;
    }

    public double getPrice_usdAsDouble() {
        try {
            return Double.parseDouble(price_usd);
        } catch (Exception e) {
            return -1; // Valor de error
        }
    }

    public void setPrice_usd(String price_usd) {
        try {
            this.price_usd = price_usd;
        } catch (Exception e) {
            this.price_usd = "0";
        }
    }

    @Override
    public String toString() {
        try {
            return "Criptomoneda{" +
                    "id='" + id + '\'' +
                    ", symbol='" + symbol + '\'' +
                    ", name='" + name + '\'' +
                    ", price_usd='" + price_usd + '\'' +
                    '}';
        } catch (Exception e) {
            return "Criptomoneda{Error al mostrar datos}";
        }
    }
}
