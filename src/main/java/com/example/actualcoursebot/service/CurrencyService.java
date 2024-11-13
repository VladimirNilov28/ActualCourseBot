package com.example.actualcoursebot.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.actualcoursebot.model.CurrencyModel;

public class CurrencyService {

    private static final String BASE_URL = "https://api.api-ninjas.com/v1/cryptoprice";
    private static final String API_KEY = "iKH6/SGxqesj59vUrQS56g==LyCgOPMswFaeFhwq"; // Лучше хранить в конфигурации

    public static String getCurrencyRate(String symbol, CurrencyModel model) throws IOException {
        URL url = new URL(BASE_URL + "?symbol=" + symbol);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-key", API_KEY);

        // Проверка успешного кода ответа
        if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            throw new IOException("Failed to fetch data: HTTP error code " + connection.getResponseCode());
        }

        try (InputStream responseStream = connection.getInputStream()) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);

            // Заполнение модели CurrencyModel
            model.setSymbol(root.path("symbol").asText());
            model.setPrice(root.path("price").asDouble());
            model.setTimestamp(root.path("timestamp").asLong());

            // Форматирование даты и времени
            String formattedDate = Instant.ofEpochSecond(model.getTimestamp())
                    .atZone(ZoneId.systemDefault())
                    .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            return "At date: " + formattedDate + "\nActual course of " + model.getSymbol() + " is " + model.getPrice();
        }
    }
}
