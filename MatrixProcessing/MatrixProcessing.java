import java.util.Scanner;
public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsA = scanner.nextInt();
        int columnsA = scanner.nextInt();
        int[][] matrixA = new int[rowsA][columnsA];
        readMatrix(scanner, matrixA, rowsA, columnsA);
        int rowsB = scanner.nextInt();
        int columnsB = scanner.nextInt();
        if (rowsA != rowsB || columnsA != columnsB) {
            System.out.println("ERROR");
            return;
        }
        int[][] matrixB = new int[rowsB][columnsB];
        readMatrix(scanner, matrixB, rowsB, columnsB);
        int[][] sumMatrix = addMatrices(matrixA, matrixB);
        printMatrix(sumMatrix);
    }
    private static void readMatrix(Scanner scanner, int[][] matrix, int rows, int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
    private static int[][] addMatrices(int[][] matrixA, int[][] matrixB) {
        int rows = matrixA.length;
        int columns = matrixA[0].length;
        int[][] sum = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                sum[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return sum;
    }
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
