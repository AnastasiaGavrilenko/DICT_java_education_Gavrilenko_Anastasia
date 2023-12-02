import java.util.Scanner;
import java.lang.Math;
public class CreditCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What do you want to calculate?");
        System.out.println("type \"n\" for number of monthly payments,");
        System.out.println("type \"a\" for annuity monthly payment amount,");
        System.out.println("type \"p\" for loan principal:");
        String calculationType = scanner.next();

        if (calculationType.equals("n")) {
            // Кількість щомісячних платежів
            System.out.println("Enter the loan principal:");
            double loanPrincipal = scanner.nextDouble();
            System.out.println("Enter the monthly payment:");
            double monthlyPayment = scanner.nextDouble();
            System.out.println("Enter the loan interest:");
            double loanInterest = scanner.nextDouble() / 100 / 12;
            int numberOfPayments = (int) Math.ceil(Math.log(monthlyPayment / (monthlyPayment - loanInterest * loanPrincipal)) / Math.log(1 + loanInterest));
            int years = numberOfPayments / 12;
            int months = numberOfPayments % 12;
            System.out.println("It will take " + years + " years and " + months + " months to repay this loan!");
        } else if (calculationType.equals("a")) {
            // Сумма щомісячного платежу
            System.out.println("Enter the loan principal:");
            double loanPrincipal = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            int numberOfPeriods = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            double loanInterest = scanner.nextDouble() / 100 / 12;
            double monthlyPayment = loanPrincipal * (loanInterest * Math.pow(1 + loanInterest, numberOfPeriods)) / (Math.pow(1 + loanInterest, numberOfPeriods) - 1);
            System.out.println("Your monthly payment = " + (int) Math.ceil(monthlyPayment) + "!");
        } else if (calculationType.equals("p")) {
            // Основна сумма кредиту
            System.out.println("Enter the annuity payment:");
            double annuityPayment = scanner.nextDouble();
            System.out.println("Enter the number of periods:");
            int numberOfPeriods = scanner.nextInt();
            System.out.println("Enter the loan interest:");
            double loanInterest = scanner.nextDouble() / 100 / 12;
            double loanPrincipal = annuityPayment / ((loanInterest * Math.pow(1 + loanInterest, numberOfPeriods)) / (Math.pow(1 + loanInterest, numberOfPeriods) - 1));
            System.out.println("Your loan principal = " + (int) Math.ceil(loanPrincipal) + "!");
        }
    }
}
