package Hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // Вивести анонс гри
        System.out.println("HANGMAN");

        // Список слів
        String[] words = {"python", "java", "javascript", "kotlin"};

        // Випадково вибрати слово зі списку
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String secretWord = words[randomIndex];

        // Запросити гравця ввести слово
        System.out.print("Guess the word: ");
        Scanner scanner = new Scanner(System.in);
        String guessedWord = scanner.nextLine();

        // Перевірити, чи вгадане слово співпадає з секретним
        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}




