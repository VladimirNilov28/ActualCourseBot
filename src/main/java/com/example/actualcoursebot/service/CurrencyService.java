package com.example.actualcoursebot.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.actualcoursebot.model.CurrencyModel;

public class CurrencyService {

    private static final String BASE_URL = "https://api.api-ninjas.com/v1/cryptoprice?symbol=LTCBTC";
    private static final String API_KEY = "iKH6/SGxqesj59vUrQS56g==LyCgOPMswFaeFhwq";

    public static String getCurrencyRate(String symbol, CurrencyModel model) throws IOException, ParseException {
        URL url = new URL(BASE_URL + "?symbol=" + symbol);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("X-Api-key", API_KEY);

        if(coonn)
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);

        model.setSymbol(root.get("symbol").asText());
        model.setPrice(root.get("price").asDouble());
        model.setTimestamp(root.get("timestamp").asInt());

        return "Actual course of " + model.getSymbol() + "is" + model.getPrice();

    }

}