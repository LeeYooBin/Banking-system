package com.currency_converter.api;

import com.currency_converter.exception.CurrencyConversionException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateApiClient {

  private static final String API_URL = "https://v6.exchangerate-api.com/v6/04a7c570add971632815eec2/pair/";

  public double getConversionRate(String from, String to) {
    String endpoint = API_URL + from + "/" + to;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
      .uri(URI.create(endpoint))
      .build();

    try {
      HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
      if (response.statusCode() != 200) {
        throw new CurrencyConversionException("Error fetching conversion rate: " + response.statusCode());
      }

      JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();
      return jsonResponse.get("conversion_rate").getAsDouble();

    } catch (IOException | InterruptedException e) {
      throw new CurrencyConversionException("Error connecting to the API", e);
    }
  }
}
