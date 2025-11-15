package com.johnnybenitez.challengeconversor2025.servicio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor implements Keys{
    private String apiKey = API_KEY;
    public Gson gson = new Gson();
    public JsonObject jsonObject;

    public double convertir(String monedaBase, String monedaDestino, double cantidad) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + monedaBase;

            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

            jsonObject = gson.fromJson(response.body(), JsonObject.class);

            double tasa = jsonObject.getAsJsonObject("conversion_rates").get(monedaDestino).getAsDouble();

            return cantidad * tasa;

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }
}
