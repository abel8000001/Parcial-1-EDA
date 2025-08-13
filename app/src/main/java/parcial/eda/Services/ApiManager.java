package parcial.eda.Services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import parcial.eda.Model.Criptomoneda.Criptomoneda;

public class ApiManager {
    private static final Logger logger = LogManager.getLogger(ApiManager.class);

    public static List<Criptomoneda> consumirApi() {

        String apiUrl = "https://api.coinlore.net/api/tickers/";

        try {
            logger.info("Iniciando consumo de API desde URL: " + apiUrl);

            // Crear cliente HTTP
            HttpClient client = HttpClient.newHttpClient();
            logger.info("Cliente HTTP creado correctamente");

            // Crear solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .header("Accept", "application/json")
                    .build();
            logger.info("Solicitud HTTP creada correctamente");

            // Enviar solicitud y obtener respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Respuesta recibida de la API con código de estado: " + response.statusCode());

            // Analizar la respuesta JSON
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            logger.info("Respuesta JSON analizada correctamente");

            // Extraer la lista de criptomonedas
            Criptomoneda[] criptomonedasArray = gson.fromJson(
                    jsonResponse.getAsJsonArray("data"), Criptomoneda[].class);
            logger.info("Se extrajeron " + criptomonedasArray.length + " criptomonedas de la API");

            // Convertir el array a una lista
            List<Criptomoneda> criptomonedas = Arrays.asList(criptomonedasArray);

            System.out.println("Base de datos obtenida con exito\n");
            logger.info("Base de datos obtenida con éxito desde la API");

            return criptomonedas;

        } catch (Exception e) {
            System.err.println("Error al consumir la API: " + e.getMessage());
            logger.error("Error al consumir la API desde URL: " + apiUrl, e);
            return new ArrayList<Criptomoneda>();
        }
    }

}
