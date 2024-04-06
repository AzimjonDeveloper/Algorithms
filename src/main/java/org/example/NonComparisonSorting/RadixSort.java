package org.example.NonComparisonSorting;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {170,546, 190, 802, 71, 2, 1900, 24, 45, 75, 66};
        int maxNum = 170;

        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr, int maxNum) {
        int digitPosition = 1;

        while (maxNum / digitPosition > 0) {
            countingSort(arr, maxNum, digitPosition);
            digitPosition *= 10;
        }
    }
    public static void countingSort(int[] array, int maxNum, int digitPosition) {
        int[] sorted = new int[array.length];

        int[] c = new int[maxNum + 1];

        for (int i = 0 ; i <= maxNum; i++) {
            c[i] = 0;
        }

        for (int j : array) {
            c[(j / digitPosition) % 10] = c[(j / digitPosition) % 10] + 1;
        }

        for (int y = 1; y < c.length; y++) {
            c[y] = c[y] + c[y - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            sorted[c[(array[i] / digitPosition) % 10] - 1] = array[i];
            c[(array[i] / digitPosition) % 10] = c[(array[i] / digitPosition) % 10] - 1;
        }

        System.arraycopy(sorted, 0, array, 0, array.length);
    }
}

