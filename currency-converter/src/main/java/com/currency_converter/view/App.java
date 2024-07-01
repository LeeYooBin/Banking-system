package com.currency_converter.view;

import com.currency_converter.service.CurrencyConversionService;
import com.currency_converter.service.ConversionHistoryService;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
  private CurrencyConversionService conversionService;
  private ConversionHistoryService historyService;
  private DateTimeFormatter dateFormatter;
  private Scanner scanner;

  public App() {
    this.conversionService = new CurrencyConversionService();
    this.historyService = new ConversionHistoryService(conversionService);
    this.dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    this.scanner = new Scanner(System.in);
  }

  public void init() {
    while (true) {
      clearScreen();
      displayMenu();
      System.out.print("Escolha uma opção: ");

      int option = scanner.nextInt();

      switch (option) {
        case 1:
          convert("BRL", "USD");
          break;
        case 2:
          convert("USD", "BRL");
          break;
        case 3:
          convert("BRL", "EUR");
          break;
        case 4:
          convert("EUR", "BRL");
          break;
        case 5:
          convert("BRL", "CNY");
          break;
        case 6:
          convert("CNY", "BRL");
          break;
        case 7:
          convert("BRL", "JPY");
          break;
        case 8:
          convert("JPY", "BRL");
          break;
        case 9:
          otherConversion();
          break;
        case 10:
          displayHistory();
          break;
        case 11:
          clearScreen();
          System.out.println("\nEncerrando o programa...\n");
          scanner.close();
          return;
        default:
          clearScreen();
          System.out.println("Opção inválida.");
          waitForKeyPress();
      }
    }
  }

  private void displayMenu() {
    System.out.println("1. Converter BRL para USD");
    System.out.println("2. Converter USD para BRL");
    System.out.println("3. Converter BRL para EUR");
    System.out.println("4. Converter EUR para BRL");
    System.out.println("5. Converter BRL para CNY");
    System.out.println("6. Converter CNY para BRL");
    System.out.println("7. Converter BRL para JPY");
    System.out.println("8. Converter JPY para BRL");
    System.out.println("9. Outra Conversão");
    System.out.println("10. Ver Histórico de Conversões");
    System.out.println("11. Sair");
  }

  private void convert(String from, String to) {
    clearScreen();
    System.out.print("Digite o valor: ");
    double amount = scanner.nextDouble();
    try {
      double result = conversionService.convert(from, to, amount);
      System.out.println(String.format("Valor convertido: %s %.2f", to, result));
    } catch (Exception e) {
      System.out.println("Erro na conversão: " + e.getMessage());
    }
    waitForKeyPress();
  }

  private void otherConversion() {
    clearScreen();
    System.out.print("Digite a moeda de origem (ex: BRL): ");
    String from = scanner.next().toUpperCase();
    System.out.print("Digite a moeda de destino (ex: USD): ");
    String to = scanner.next().toUpperCase();
    convert(from, to);
  }

  private void displayHistory() {
    clearScreen();
    historyService.displayHistory(dateFormatter);
    waitForKeyPress();
  }

  private void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private void waitForKeyPress() {
    System.out.println("Pressione Enter para continuar...");
    try {
      System.in.read();
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
