public class ChatBot {
    public static void main(String[] args) {
        // Отримуємо поточний рік
        int currentYear = java.time.Year.now().getValue();

        // Виводимо привітання та інформацію про бота
        System.out.println("Hello! My name is MyBot.");
        System.out.println("I was created in " + currentYear + ".");
    }
}