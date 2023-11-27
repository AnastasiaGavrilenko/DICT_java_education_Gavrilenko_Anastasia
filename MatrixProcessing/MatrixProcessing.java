import java.util.Scanner;
public class MatrixProcessing {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Add matrices\n2. Multiply matrix by a constant\n3. Multiply matrices\n0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addMatrices();
                    break;
                case 2:
                    multiplyMatrixByConstant();
                    break;
                case 3:
                    multiplyMatrices();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    private static void addMatrices() {
        System.out.println("Enter size of first matrix:");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[][] firstMatrix = readMatrix(rows, columns);

        System.out.println("Enter size of second matrix:");
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        double[][] secondMatrix = readMatrix(rows, columns);

        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        double[][] resultMatrix = new double[firstMatrix.length][firstMatrix[0].length];
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[0].length; j++) {
                resultMatrix[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }

        printMatrix(resultMatrix);
    }
    private static void multiplyMatrixByConstant() {
        System.out.println("Enter size of matrix:");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();
        double[][] matrix = readMatrix(rows, columns);

        System.out.println("Enter constant:");
        double constant = scanner.nextDouble();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] *= constant;
            }
        }
        printMatrix(matrix);
    }
    private static void multiplyMatrices() {
        System.out.println("Enter size of first matrix:");
        int rowsFirst = scanner.nextInt();
        int columnsFirst = scanner.nextInt();
        double[][] firstMatrix = readMatrix(rowsFirst, columnsFirst);

        System.out.println("Enter size of second matrix:");
        int rowsSecond = scanner.nextInt();
        int columnsSecond = scanner.nextInt();
        double[][] secondMatrix = readMatrix(rowsSecond, columnsSecond);

        if (columnsFirst != rowsSecond) {
            System.out.println("The operation cannot be performed.");
            return;
        }
        double[][] resultMatrix = new double[rowsFirst][columnsSecond];
        for (int i = 0; i < rowsFirst; i++) {
            for (int j = 0; j < columnsSecond; j++) {
                for (int k = 0; k < columnsFirst; k++) {
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        printMatrix(resultMatrix);
    }
    private static double[][] readMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        System.out.println("Enter matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }
    private static void printMatrix(double[][] matrix) {
        System.out.println("The result is:");
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
