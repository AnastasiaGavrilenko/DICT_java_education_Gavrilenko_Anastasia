package Hangman;

import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        // Вивести анонс гри
        System.out.println("HANGMAN");
        System.out.println("Guess the word:");

        // Слово, яке гравець повинен вгадати
        String secretWord = "java";

        // Запросити гравця ввести слово
        Scanner scanner = new  Scanner(System.in);
        String guessedWord = scanner.nextLine();

        // Перевірити, чи вгадане слово співпадає з секретним
        if (guessedWord.equals(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }
    }
}





