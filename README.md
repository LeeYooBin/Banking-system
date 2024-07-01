# Currency Converter

O Currency Converter é um aplicativo de linha de comando para conversão de moedas utilizando a API do Exchange Rates. Ele permite converter valores entre diferentes moedas e mantém um histórico das últimas conversões realizadas.

## Funcionalidades

- Converter BRL para USD, EUR, CNY, JPY e vice-versa.
- Converter entre outras moedas especificadas pelo usuário.
- Exibir o histórico das últimas conversões realizadas.

## Requisitos

- Java 17 ou superior
- Maven

## Como usar

1. **Clone o repositório:**

```sh
git clone https://github.com/seu-usuario/currency-converter-cli.git
cd currency-converter
```
2. **Compile o projeto usando Maven**
```sh
mvn clean package
```
3. **Execute o aplicativo**
```sh
java -cp target/classes com.currency_converter.Main
```

## Exemplo de uso

Ao executar o aplicativo, você verá um menu como o seguinte:
```bash
1. Converter BRL para USD
2. Converter USD para BRL
3. Converter BRL para EUR
4. Converter EUR para BRL
5. Converter BRL para CNY
6. Converter CNY para BRL
7. Converter BRL para JPY
8. Converter JPY para BRL
9. Outra Conversão
10. Ver Histórico de Conversões
11. Sair
```
Escolha uma opção e siga as instruções na tela para realizar a conversão desejada.

## Tecnologias utilizadas
- Java 17
- Maven
- HttpClient (para fazer requisições HTTP)
- Gson (para parsing de JSON)
- Java Time API (para registro de data e hora)