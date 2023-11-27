import java.util.Scanner;
public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 4) {
                System.out.println("1. Main diagonal");
                System.out.println("2. Side diagonal");
                System.out.println("3. Vertical line");
                System.out.println("4. Horizontal line");
                System.out.print("Your choice: ");
                int transposeChoice = scanner.nextInt();
                System.out.print("Enter matrix size (rows columns): ");
                int rows = scanner.nextInt();
                int cols = scanner.nextInt();
                int[][] matrix = new int[rows][cols];
                System.out.println("Enter matrix:");
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                int[][] transposedMatrix;
                switch (transposeChoice) {
                    case 1:
                        transposedMatrix = transposeMainDiagonal(matrix);
                        break;
                    case 2:
                        transposedMatrix = transposeSideDiagonal(matrix);
                        break;
                    case 3:
                        transposedMatrix = transposeVertical(matrix);
                        break;
                    case 4:
                        transposedMatrix = transposeHorizontal(matrix);
                        break;
                    default:
                        System.out.println("Invalid choice");
                        continue;
                }
                System.out.println("The result is:");
                printMatrix(transposedMatrix);
            }
        }
    }
    public static int[][] transposeMainDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
    public static int[][] transposeSideDiagonal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[cols - 1 - j][rows - 1 - i] = matrix[i][j];
            }
        }

        return transposedMatrix;
    }

    public static int[][] transposeVertical(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[i][j] = matrix[i][cols - 1 - j];
            }
        }

        return transposedMatrix;
    }

    public static int[][] transposeHorizontal(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[i][j] = matrix[rows - 1 - i][j];
            }
        }

        return transposedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
