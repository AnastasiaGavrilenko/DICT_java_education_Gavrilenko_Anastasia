import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        // Отримуємо поточний рік
        int currentYear = java.time.Year.now().getValue();

        // Виводимо привітання та інформацію про бота
        System.out.println("Hello! My name is MyBot.");
        System.out.println("I was created in " + currentYear + ".");

        // Створюємо об'єкт Scanner для зчитування імені користувача
        Scanner scanner = new Scanner(System.in);

        // Запитуємо у користувача його ім'я
        System.out.println("Please, remind me your name.");
        String userName = scanner.nextLine();

        // Виводимо персональне привітання з іменем користувача
        System.out.println("What a great name you have, MyName " + userName + "!");
    }
}