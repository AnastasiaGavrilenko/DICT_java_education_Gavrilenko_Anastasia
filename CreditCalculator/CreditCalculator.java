import java.util.Scanner;

public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запит на сумму кредиту
        System.out.println("Enter the loan principal:");
        double loanPrincipal = scanner.nextDouble();

        // Запит на який параметр користувач хоче розрахувати
        System.out.println("What do you want to calculate?");
        System.out.println("Type \"m\" – for number of monthly payments,");
        System.out.println("Type \"p\" – for the monthly payment:");
        String calculationType = scanner.next();

        if (calculationType.equals("m")) {
            System.out.println("Enter the monthly payment:");
            double monthlyPayment = scanner.nextDouble();
            int numberOfMonths = (int) Math.ceil(loanPrincipal / monthlyPayment);
            System.out.println("It will take " + numberOfMonths + " months to repay the loan");
        } else if (calculationType.equals("p")) {
            System.out.println("Enter the number of months:");
            int numberOfMonths = scanner.nextInt();
            double monthlyPayment = loanPrincipal / numberOfMonths;
            double lastPayment = loanPrincipal - (numberOfMonths - 1) * monthlyPayment;
            System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment));
            if (lastPayment != monthlyPayment) {
                System.out.println("and the last payment = " + (int) Math.ceil(lastPayment));
            }
        }
    }
}
