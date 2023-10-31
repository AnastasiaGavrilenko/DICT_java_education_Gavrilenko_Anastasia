package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int waterAvailable = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int milkAvailable = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeansAvailable = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int cupsNeeded = scanner.nextInt();

        int cupsByWater = waterAvailable / 200;
        int cupsByMilk = milkAvailable / 50;
        int cupsByCoffeeBeans = coffeeBeansAvailable / 15;

        int possibleCups = Math.min(cupsByWater, Math.min(cupsByMilk, cupsByCoffeeBeans));

        if (cupsNeeded == possibleCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsNeeded < possibleCups) {
            int extraCups = possibleCups - cupsNeeded;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        } else {
            System.out.println("No, I can make only " + possibleCups + " cups of coffee");
        }
    }
}
