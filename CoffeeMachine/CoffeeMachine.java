package CoffeeMachine;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many cups of coffee would you like to make?");
        int cups = scanner.nextInt();

        int waterNeeded = cups * 200;      // 200 ml of water per cup
        int milkNeeded = cups * 50;        // 50 ml of milk per cup
        int coffeeBeansNeeded = cups * 15; // 15 g of coffee beans per cup

        System.out.println("To make " + cups + " cups of coffee, you will need:");
        System.out.println(waterNeeded + " ml of water");
        System.out.println(milkNeeded + " ml of milk");
        System.out.println(coffeeBeansNeeded + " g of coffee beans");
    }
}
