import java.util.Scanner;
public class CurrencyExchange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mycoins = 0.0;
        while (true) {
            try {
                System.out.print("Please, enter the number of mycoins you have: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid numeric value.");
                    System.out.print("Please, enter the number of mycoins you have: ");
                    scanner.next();
                }
                mycoins = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                scanner.next();
            }
        }

        double exchangeRate = 0.0;
        while (true) {
            try {
                System.out.print("Please, enter the exchange rate: ");
                while (!scanner.hasNextDouble()) {
                    System.out.println("Invalid input. Please enter a valid numeric value.");
                    System.out.print("Please, enter the exchange rate: ");
                    scanner.next();
                }
                exchangeRate = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid numeric value.");
                scanner.next();
            }
        }

        double dollars = mycoins * exchangeRate;
        System.out.println("The total amount of dollars: " + dollars);

        scanner.close();
    }
}
