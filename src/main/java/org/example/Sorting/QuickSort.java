package org.example.Sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {15, 12, 39, 19, 18};
        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int p, int r) {
        if(p < r) {
            int pivot = partition(array, p, r);
            quickSort(array, p, pivot - 1);
            quickSort(array, pivot + 1, r);
        }
    }

    public static int partition(int [] array, int p, int q) {
        int i = p;
        int temp;

        for (int j = p + 1; j <= q; j++) {
            if (array[p] >= array[j]) {
                i++;

                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                // Swap(A[i] and A[j])
            }
        }
        // SWAP(A[p] and A[i])
        temp = array[i];
        array[i] = array[p];
        array[p] = temp;

        return i;
    }


    public static int median(int a, int b, int c) {
        if(a > b && b > c) {
            return b;
        } else if (b > a && a > c) {
            return a;
        }
        return c;

        // GUSPANDMI TU IFLOS
    }
}
