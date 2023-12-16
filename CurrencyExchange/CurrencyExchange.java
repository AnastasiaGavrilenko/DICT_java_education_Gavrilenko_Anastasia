import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##"); // Форматування для округлення до двох знаків після коми

        // Курси обміну для різних валют
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("ARS", 0.82);
        exchangeRates.put("HNL", 0.17);
        exchangeRates.put("AUD", 1.9622);
        exchangeRates.put("MAD", 0.208);

        // Зчитування кількості валюти
        double mycoins = 0.0;
        while (true) {
            try {
                System.out.print("Please, enter the number of mycoins you have: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid numeric value.");
                    System.out.print("Please, enter the number of mycoins you have: ");
                    scanner.next(); // прочитати невірне значення
                }
                mycoins = scanner.nextDouble();
                break; // вихід з циклу, якщо вдало зчитано число
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                scanner.next(); // прочитати невірне значення
            }
        }

        // Конвертація та виведення результатів
        for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) {
            String currency = entry.getKey();
            double rate = entry.getValue();
            double convertedAmount = mycoins * rate;
            System.out.println("I will get " + df.format(convertedAmount) + " " + currency +
                    " from the sale of " + mycoins + " mycoins.");
        }

        // Закриття Scanner
        scanner.close();
    }
}
