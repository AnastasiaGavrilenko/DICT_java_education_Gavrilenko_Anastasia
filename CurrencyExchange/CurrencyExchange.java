import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import java.util.Scanner;


public class CurrencyExchange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Зчитування коду валюти від користувача
        System.out.print("Please, enter the currency code (e.g., USD): ");
        String baseCurrency = scanner.next().toUpperCase();

        // Зчитування кількості валюти від користувача
        System.out.print("Please, enter the amount of " + baseCurrency + ": ");
        double amount = scanner.nextDouble();

        // Виклик методу для отримання та виведення курсів обміну
        getAndDisplayExchangeRates(baseCurrency, amount);

        // Закриття Scanner
        scanner.close();
    }

    private static void getAndDisplayExchangeRates(String baseCurrency, double amount) {
        // Масив цільових валют
        String[] targetCurrencies = {"USD", "EUR", "GBP", "JPY", "AUD"};

        // Виведення заголовку результатів
        System.out.println("Exchange rates for " + amount + " " + baseCurrency + ":");
        System.out.println("-------------------------");

        // Виведення курсів обміну для кожної цільової валюти
        for (String targetCurrency : targetCurrencies) {
            getExchangeRateAndPrint(baseCurrency, targetCurrency, amount);
        }
    }

    private static void getExchangeRateAndPrint(String baseCurrency, String targetCurrency, double amount) {
        try {
            // Створення URL для запиту
            URL url = new URL("https://api.exchangerate-api.com/v4/latest/" + baseCurrency);

            // Отримання об'єкта HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Перевірка коду відповіді
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Читання відповіді
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Обробка JSON-відповіді
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject rates = jsonResponse.getJSONObject("rates");
                double exchangeRate = rates.getDouble(targetCurrency);

                // Обчислення суми у цільовій валюті
                double targetAmount = amount * exchangeRate;

                // Виведення результату
                System.out.println(amount + " " + baseCurrency + " is equal to " + targetAmount + " " + targetCurrency);
            } else {
                System.out.println("Error fetching exchange rate. HTTP response code: " + responseCode);
            }

            // Закриття з'єднання
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }
    }
}
