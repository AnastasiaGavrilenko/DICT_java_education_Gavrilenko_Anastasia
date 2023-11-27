import java.util.Scanner;
public class MatrixProcessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("5. Calculate a determinant");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 5) {
                System.out.print("Enter matrix size (n x n): ");
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                System.out.println("Enter matrix:");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                int determinant = calculateDeterminant(matrix);
                System.out.println("The result is: " + determinant);
            }
        }
    }
    public static int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        int determinant = 0;

        for (int i = 0; i < n; i++) {
            int[][] subMatrix = new int[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                for (int k = 0, l = 0; k < n; k++) {
                    if (k == i) continue;
                    subMatrix[j - 1][l++] = matrix[j][k];
                }
            }
            int sign = (i % 2 == 0) ? 1 : -1;
            determinant += sign * matrix[0][i] * calculateDeterminant(subMatrix);
        }
        return determinant;
    }
}
