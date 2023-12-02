public class CreditCalculator {
    public static void main(String[] args) {
        double loanPrincipal = 1000.0;
        double monthlyPayment = 250.0;
        int month = 1;
        while (loanPrincipal > 0) {
            System.out.println("Month " + month + ": repaid " + monthlyPayment);
            loanPrincipal -= monthlyPayment;

            if (loanPrincipal <= 0) {
                System.out.println("The loan has been repaid!");
            }
            month++;
        }
    }
}
