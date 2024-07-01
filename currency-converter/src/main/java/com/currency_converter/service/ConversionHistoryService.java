package com.currency_converter.service;

import com.currency_converter.model.ConversionEntry;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ConversionHistoryService {
  private CurrencyConversionService conversionService;

  public ConversionHistoryService(CurrencyConversionService conversionService) {
    this.conversionService = conversionService;
  }

  public void displayHistory(DateTimeFormatter dateFormatter) {
    List<ConversionEntry> history = conversionService.getConversionHistory();
    if (history.isEmpty()) {
      System.out.println("Nenhuma conversão realizada ainda.");
    } else {
      history.forEach(record -> {
        System.out.println(record.toString(dateFormatter));
      });
    }
  }
}
