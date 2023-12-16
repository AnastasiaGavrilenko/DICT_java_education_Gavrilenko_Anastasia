import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.JSONObject;
public class CurrencyExchange {

    private static double exchangeRate;

    // Кеш для збереження обмінних курсів
    private static Map<String, Double> exchangeRateCache = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String baseCurrency;
        do {
            // Отримання коду валюти для обміну
            System.out.print("Please, enter the currency code (e.g., USD): ");
            baseCurrency = scanner.next().toUpperCase();

            if (!baseCurrency.isEmpty()) {
                // Отримання коду валюти, на яку хочете обміняти
                System.out.print("Please, enter the target currency code: ");
                String targetCurrency = scanner.next().toUpperCase();

                // Отримання суми грошей для обміну
                System.out.print("Please, enter the amount of " + baseCurrency + ": ");
                double amount = scanner.nextDouble();

                // Перевірка кешу та виведення результату
                checkAndExchange(baseCurrency, targetCurrency, amount);
            }
        } while (!baseCurrency.isEmpty());

        // Закриття Scanner
        scanner.close();
    }

    private static void checkAndExchange(String baseCurrency, String targetCurrency, double amount) {
        // Створення ключа для кешу
        String cacheKey = baseCurrency + "-" + targetCurrency;

        // Перевірка, чи є обмінний курс в кеші
        if (exchangeRateCache.containsKey(cacheKey)) {
            // Використання кешованого значення
            double exchangeRate = exchangeRateCache.get(cacheKey);
            double exchangedAmount = amount * exchangeRate;
            System.out.println("Checking the cache...\nIt is in the cache!\nYou received " + exchangedAmount + " " + targetCurrency + ".");
        } else {
            // Якщо немає в кеші, робимо запит та розраховуємо суму
            double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
            if (exchangeRate != -1) {
                double exchangedAmount = amount * exchangeRate;
                System.out.println("Checking the cache...\nSorry, but it is not in the cache!\nYou received " + exchangedAmount + " " + targetCurrency + ".");
                // Збереження в кеші
                exchangeRateCache.put(cacheKey, exchangeRate);
            }
        }
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) {
        try {
            // Створення URL для запиту
            URL url = new URL("http://www.floatrates.com/daily/" + baseCurrency + ".json");

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

                JSONObject jsonResponse = new JSONObject(response.toString());

                // Оновлення наступного рядка для розпізнавання нової структури
                JSONObject rates = jsonResponse.optJSONObject("rates");

                if (rates != null) {
                    double exchangeRate = rates.optDouble(targetCurrency.toUpperCase());
                    if (!Double.isNaN(exchangeRate)) {
                        System.out.println("Exchange rate: " + exchangeRate);
                    } else {
                        System.out.println("Error: Exchange rate not available for the target currency.");
                    }
                } else {
                    System.out.println("Error: 'rates' object not found in the JSON response.");
                }

                // Закриття з'єднання
                connection.disconnect();

                // Повернення обмінного курсу
                return exchangeRate;
            } else {
                System.out.println("Error fetching exchange rate. HTTP response code: " + responseCode);
            }

            // Закриття з'єднання
            connection.disconnect();
        } catch (Exception e) {
            System.out.println("Error fetching exchange rate: " + e.getMessage());
        }

        // Повернення значення -1 у випадку помилки
        return -1;
       }
    }
