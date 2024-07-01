package com.currency_converter.service;

import com.currency_converter.api.ExchangeRateApiClient;
import com.currency_converter.model.ConversionEntry;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CurrencyConversionService {
  private ExchangeRateApiClient apiClient;
  private List<ConversionEntry> conversionHistory;

  public CurrencyConversionService() {
    this.apiClient = new ExchangeRateApiClient();
    this.conversionHistory = new ArrayList<>();
  }

  public double convert(String from, String to, double amount) {
    double conversionRate = apiClient.getConversionRate(from, to);
    double convertedAmount = amount * conversionRate;
    conversionHistory.add(new ConversionEntry(from, to, amount, convertedAmount, LocalDateTime.now()));
    return convertedAmount;
  }

  public List<ConversionEntry> getConversionHistory() {
    return conversionHistory;
  }
}
