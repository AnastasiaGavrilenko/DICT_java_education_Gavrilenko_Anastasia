import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();
        char[][] board = createBoard(cells);

        printGameBoard(board);
        makeMove(board, scanner);
        printGameBoard(board);
    }
    private static char[][] createBoard(String cells) {
        char[][] board = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = cells.charAt(i * 3 + j);
            }
        }
        return board;
    }
    private static void printGameBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    private static void makeMove(char[][] board, Scanner scanner) {
        while (true) {
            System.out.print("Enter the coordinates: ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            try {
                int x = Integer.parseInt(parts[0]) - 1;
                int y = Integer.parseInt(parts[1]) - 1;

                if (x < 0 || x >= 3 || y < 0 || y >= 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[x][y] != '_') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    board[x][y] = 'X';
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
