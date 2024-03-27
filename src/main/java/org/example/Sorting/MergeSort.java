package org.example.Sorting;

public class MergeSort {
    public static void main(String [] args) {
        int[] array = {34,2,3,54,564,42, 1};
        sort(array, 0, array.length - 1);

        for (int j : array) {
            System.out.println(j);
        }
    }

    public static void sort(int[] arr, int l, int r) {
        if (l < r) {
            int q = (l + r) / 2;
            sort(arr, l, q);
            sort(arr, q + 1, r);
            merge(arr, l, q, r);
        }
    }

    private static void merge(int[] arr, int l, int q, int r) {
        int n1 = q - l + 1;
        int n2 = r - q;

        int[] arr1 = new int[n1 + 1];
        int[] arr2 = new int[n2 + 1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[l + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[q + i + 1];
        }
        arr1[n1] = Integer.MAX_VALUE;
        arr2[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        for (int k = l; k <= r; k++) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
        }

    }
}
