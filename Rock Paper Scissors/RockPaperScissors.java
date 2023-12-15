import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String userChoice = scanner.nextLine().toLowerCase();
        String computerChoice = getComputerChoice(userChoice);

        // Вивести результат
        System.out.println("Sorry, but the computer chose " + computerChoice);
    }
    private static String getComputerChoice(String userChoice) {
        switch (userChoice) {
            case "rock":
                return "paper";
            case "paper":
                return "scissors";
            case "scissors":
                return "rock";
            default:
                return ""; 
        }
    }
}
