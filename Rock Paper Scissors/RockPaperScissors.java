import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("> ");
        String userChoice = scanner.nextLine().toLowerCase();
        String computerChoice = getRandomChoice();
        String result = getResult(userChoice, computerChoice);
        // Вивести підсумковий рядок
        System.out.println(result);
    }
    private static String getRandomChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }
    private static String getResult(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "There is a draw (" + computerChoice + ")";
        } else if (
                (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                        (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                        (userChoice.equals("scissors") && computerChoice.equals("paper"))
        ) {
            return "Well done. The computer chose " + computerChoice + " and failed";
        } else {
            return "Sorry, but the computer chose " + computerChoice;
        }
    }
}
