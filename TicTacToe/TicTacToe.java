import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String cells = scanner.nextLine();
        printGameBoard(cells);
        analyzeGameState(cells);
    }
    private static void printGameBoard(String cells) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    private static void analyzeGameState(String cells) {
        boolean xWins = isWinner(cells, 'X');
        boolean oWins = isWinner(cells, 'O');
        int xCount = countChar(cells, 'X');
        int oCount = countChar(cells, 'O');

        if ((xWins && oWins) || Math.abs(xCount - oCount) > 1) {
            System.out.println("Impossible");
        } else if (xWins) {
            System.out.println("X wins");
        } else if (oWins) {
            System.out.println("O wins");
        } else if (cells.contains("_") || cells.contains(" ")) {
            System.out.println("Game not finished");
        } else {
            System.out.println("Draw");
        }
    }
    private static boolean isWinner(String cells, char player) {
        String rowPattern = "" + player + player + player;
        for (int i = 0; i < 3; i++) {
            if (cells.substring(i * 3, i * 3 + 3).equals(rowPattern) ||
                    (cells.charAt(i) == player && cells.charAt(i + 3) == player && cells.charAt(i + 6) == player)) {
                return true;
            }
        }
        return (cells.charAt(0) == player && cells.charAt(4) == player && cells.charAt(8) == player) ||
                (cells.charAt(2) == player && cells.charAt(4) == player && cells.charAt(6) == player);
    }
    private static int countChar(String str, char ch) {
        return (int) str.chars().filter(c -> c == ch).count();
    }
}
