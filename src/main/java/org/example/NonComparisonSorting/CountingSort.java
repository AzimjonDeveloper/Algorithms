package org.example.NonComparisonSorting;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {

        // Problem 8.1a
        int[] arrCounting = {9, 1, 6, 7, 6, 2, 1};

        counting_sort(arrCounting, 9);

        System.out.println(Arrays.toString(arrCounting));
    }

    public static void counting_sort(int[] array, int maxNum) {
        int[] sorted = new int[array.length];

        int[] c = new int[maxNum + 1];

        for (int i = 0 ; i < maxNum; i++) {
            c[i] = 0;
        }

        for (int j : array) {
            c[j] = c[j] + 1;
        }

        for (int y = 1; y < c.length; y++) {
            c[y] = c[y] + c[y - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            sorted[c[array[i]] - 1] = array[i];
            c[array[i]] = c[array[i]] - 1;
        }

        System.arraycopy(sorted, 0, array, 0, array.length);
    }
}