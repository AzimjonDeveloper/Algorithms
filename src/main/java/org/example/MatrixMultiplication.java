package org.example;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] a = {{3,5}, {2,4}};
        int[][] b = {{1,5}, {5,4}};

        int[][] c = multiply(a,b);

        for (int i = 0; i < 2; i++) {
            for (int y = 0; y < 2; y++) {
                System.out.print(c[i][y] + " ");
            }
            System.out.println();
        }
    }

    // O(n^3)
    public static int[][] multiply(int [][] A, int[][] B) {
        int[][] c = new int[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                c[i][j] = 0;
                for (int k = 0; k < A.length; k++) {
                    c[i][j] = c[i][j] + A[i][k] * B[k][j];
                }
            }
        }
        return c;
    }





    //TODO Strassen's Idea Product Multiplication
}
