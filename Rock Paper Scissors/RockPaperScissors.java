import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: > ");
        String userName = scanner.nextLine();

        int userScore = readUserScore(userName);

        System.out.println("Hello, " + userName);

        while (true) {
            System.out.print("> ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (userInput.equals("!rating")) {
                System.out.println("Your rating: " + userScore);
            } else if (userInput.equals("rock") || userInput.equals("paper") || userInput.equals("scissors")) {
                playGame(userInput, userName, userScore);
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private static void playGame(String userChoice, String userName, int userScore) {
        String computerChoice = getRandomChoice();
        String result = getResult(userChoice, computerChoice);
        int roundScore = calculateRoundScore(result);
        int newScore = userScore + roundScore;
        writeUserScore(userName, newScore);

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

    private static int calculateRoundScore(String result) {
        if (result.contains("draw")) {
            return 50;
        } else if (result.contains("Well done")) {
            return 100;
        } else {
            return 0;
        }
    }

    private static int readUserScore(String userName) {
        try (BufferedReader reader = new BufferedReader(new FileReader("out/rating.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2 && parts[0].equals(userName)) {
                    return Integer.parseInt(parts[1]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static void writeUserScore(String userName, int userScore) {
        try (FileWriter writer = new FileWriter("rating.txt", true)) {
            writer.write(userName + " " + userScore + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
