import java.io.*;
import java.util.*;

public class RockPaperScissors {
    private static int userScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName);

        Map<String, Integer> options = readUserOptions(scanner);
        System.out.println("Okay, let's start.");

        while (true) {
            System.out.print("> ");
            String userChoice = scanner.nextLine();

            if ("!exit".equals(userChoice)) {
                System.out.println("Bye!");
                break;
            }

            if (options.containsKey(userChoice)) {
                playRound(userChoice, options);
                System.out.println("!rating");
                System.out.println("Your rating: " + userScore);
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private static Map<String, Integer> readUserOptions(Scanner scanner) {
        System.out.print("Enter options (comma-separated): ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
            return Map.of("rock", 1, "paper", 2, "scissors", 3);
        }

        String[] optionsArray = input.split(", ");
        Map<String, Integer> options = new HashMap<>();

        for (int i = 0; i < optionsArray.length; i++) {
            options.put(optionsArray[i], i + 1);
        }

        return options;
    }

    private static void playRound(String userChoice, Map<String, Integer> options) {
        String[] optionsArray = options.keySet().toArray(new String[0]);
        int computerChoiceIndex = (int) (Math.random() * optionsArray.length);
        String computerChoice = optionsArray[computerChoiceIndex];

        int result = determineWinner(userChoice, computerChoice, options);
        if (result == 0) {
            System.out.println("There is a draw (" + computerChoice + ")");
        } else if (result == 1) {
            System.out.println("Well done. The computer chose " + computerChoice + " and failed");
            userScore += 100;
        } else {
            System.out.println("Sorry, but the computer chose " + computerChoice);
        }
    }

    private static int determineWinner(String userChoice, String computerChoice, Map<String, Integer> options) {
        int userIndex = options.get(userChoice);
        int computerIndex = options.get(computerChoice);

        int halfSize = options.size() / 2;
        if (userIndex == computerIndex) {
            return 0;
        } else if ((userIndex > computerIndex && userIndex - computerIndex <= halfSize) ||
                (userIndex < computerIndex && computerIndex - userIndex > halfSize)) {
            return 1;
        } else {
            return -1;
        }
    }
}
