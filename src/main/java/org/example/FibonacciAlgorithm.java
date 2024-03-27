package org.example;

import static java.lang.Math.sqrt;

public class FibonacciAlgorithm {
    public static void main(String[] args) {
        System.out.println(naiveFibonacci(7));
    }

    // Naive algorithm
    // Time Complexity: Omega(2^(n/2))
    public static int naiveFibonacci(int num) {
        if(num < 2) {
            return  num;
        }
        return naiveFibonacci(num - 1) + naiveFibonacci(num - 2);
    }

    public static int fibonacciBottomUp(int n) {
        int[] num = new int[n + 1];
        num[0] = 0;
        num[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            num[i] = num[i - 2] + num[i - 1];
        }
        return num[n];
    }

    // Time complexity Math.pow() is O(logN)
    public static int fibonacciClosedForm(int n) {
        double f = (1 + sqrt(5)) / 2;
        return (int) Math.round(Math.pow(f , n) / Math.sqrt(5));
    }


    // ----------------- Fibonacci Using Matrix Multiplication ----------------------//
    public static int fibonacciMatrix(int n) {

        int[][] base = {{1,1}, {1, 0}};
        int[][] result = powMatrix(base, n);

        return result[0][1];
    }

    private static int[][] powMatrix(int[][] matrix, int ex) {
        if (ex == 0) {
            return new int[][]{{1, 0}, {0, 1}};
        }

        if(ex == 1) {
            return matrix;
        }
        if(ex % 2 == 0) {
            int[][] halfSize = powMatrix(matrix, ex / 2);
            return multiply2by2(halfSize, halfSize);
        } else {
            int[][] halfSize = powMatrix(matrix, ex  / 2);
            int[][] result = multiply2by2(halfSize, halfSize);
            return multiply2by2(result, halfSize);
        }
    }

    public static int[][] multiply2by2(int [][] a, int [][] b) {
        int [][] result = new int[2][2];
        for(int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    result[i][j] = result[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }
}