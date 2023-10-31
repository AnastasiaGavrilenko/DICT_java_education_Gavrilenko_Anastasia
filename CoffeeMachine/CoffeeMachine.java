package CoffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();

            if (action.equals("buy")) {
                buyCoffee(scanner);
            } else if (action.equals("fill")) {
                fillMachine(scanner);
            } else if (action.equals("take")) {
                takeMoney();
            } else if (action.equals("remaining")) {
                displayMachineStatus();
            } else if (action.equals("exit")) {
                isRunning = false;
            } else {
                System.out.println("Invalid action. Please try again.");
            }
        }
    }
    private static void buyCoffee(Scanner scanner) {
    }
    private static void fillMachine(Scanner scanner) {
    }
    private static void takeMoney() {
    }
    private static void displayMachineStatus() {
    }
}
