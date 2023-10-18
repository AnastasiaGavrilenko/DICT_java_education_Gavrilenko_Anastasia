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
        String MyName = scanner.nextLine();

        // Виводимо персональне привітання з іменем користувача
        System.out.println("What a great name you have, MyName " + MyName + "!");

        // Спробуємо вгадати вік користувача
        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        // Зчитуємо залишки від ділення на 3, 5 і 7
        int remainder3 = Integer.parseInt(scanner.nextLine());
        int remainder5 = Integer.parseInt(scanner.nextLine());
        int remainder7 = Integer.parseInt(scanner.nextLine());

        // Обчислюємо вік за формулою
        int userAge = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        // Виводимо вгаданий вік
        System.out.println("Your age is " + userAge + "; that's a good time to start programming!");
    }
}