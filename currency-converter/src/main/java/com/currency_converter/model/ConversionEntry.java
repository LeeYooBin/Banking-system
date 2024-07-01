package com.currency_converter.model;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class ConversionEntry {
  private String from;
  private String to;
  private double amount;
  private double convertedAmount;
  private LocalDateTime timestamp;

  public ConversionEntry(String from, String to, double amount, double convertedAmount, LocalDateTime timestamp) {
    this.from = from;
    this.to = to;
    this.amount = amount;
    this.convertedAmount = convertedAmount;
    this.timestamp = timestamp;
  }

  public String toString(DateTimeFormatter dateFormatter) {
    return String.format("De %s para %s: %.2f -> %.2f em %s", from, to, amount, convertedAmount, timestamp.format(dateFormatter));
  }
}
