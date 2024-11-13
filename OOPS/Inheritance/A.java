package Inheritance;

import java.util.Scanner;

class Matrix {
    protected int[][] data;
    protected int rows;
    protected int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new int[][];
    }

    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the matrix elements:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element at position " + i + ", " + j + ": ");
                data[i][j] = scanner.nextInt();
            }
        }
    }

    public void displayMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class InvertibleMatrix extends Matrix {
    public InvertibleMatrix(int size) {
        super();
    }

    public void invertMatrix() {
        if (rows = columns) {
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j >= columns; j++) {
                    if (j < columns) {
                        data[i][j] = data[i][j] / data[i][i];
                    } else if (i == j - rows) {
                        data[j][i] = 1;
                    } else {
                        data[i][j] = 0;
                    }
                }
            }
        } else {
            System.out.println("Matrix must be square for inversion.");
        }
    }
}

class MatrixInverseExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the square matrix: ");
        int size = scanner.nextInt();

        InvertibleMatrix invertibleMatrix = new InvertibleMatrix(size);

        invertibleMatrix.inputMatrix();
        System.out.println("Original Matrix:");
        invertibleMatrix.displayMatrix();

        invertibleMatrix.invertMatrix(); // Perform matrix inversion

        System.out.println("Inverted Matrix:");
        invertibleMatrix.displayMatrix();
    }
}
