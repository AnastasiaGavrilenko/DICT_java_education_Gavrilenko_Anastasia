import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // Список слів для вибору
        String[] wordList = {"python", "java", "javascript", "kotlin"};

        // Випадково вибираємо слово зі списку
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.length);
        String secretWord = wordList[randomIndex];

        // Змінні для відслідковування спроб та введених букв
        int remainingAttempts = 8;
        StringBuilder guessedWord = new StringBuilder("-".repeat(secretWord.length()));

        // Виведення анонсу гри "HANGMAN"
        System.out.println("HANGMAN");

        // Головний цикл гри
        while (remainingAttempts > 0) {
            System.out.println(guessedWord);
            System.out.print("Input a letter: > ");
            Scanner scanner = new Scanner(System.in);
            String playerGuess = scanner.next();

            if (secretWord.contains(playerGuess)) {
                // Гравець вгадав правильно
                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == playerGuess.charAt(0)) {
                        guessedWord.setCharAt(i, playerGuess.charAt(0));
                    }
                }
            } else {
                // Гравець помилився
                System.out.println("That letter doesn't appear in the word");
                remainingAttempts--;
            }

            // Перевірка, чи гравець вгадав всі літери
            if (guessedWord.toString().equals(secretWord)) {
                System.out.println("Congratulations! You've guessed the word: " + secretWord);
                break;
            }
        }

        // Закінчення гри
        if (remainingAttempts == 0) {
            System.out.println("Thanks for playing!");
            System.out.println("We'll see how well you did in the next stage");
        }
    }
}
