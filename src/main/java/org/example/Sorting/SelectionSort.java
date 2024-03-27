package org.example.Sorting;

import java.io.IOException;
import java.util.Random;

public class SelectionSort {
    public static void main(String [] args) throws IOException {
        int[] array = new int[5];

        for (int i = 4; i >= 0; i--) {
            array[4 - i] = i;
        }
        selection_sort(array);
        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }
    }

    public static int[] generateRandom(int n) {
        // Uses the class Random from java standard library to generate random number
        Random random = new Random();
        int[] randomList = new int[n];
        for (int i = 0; i < n; i++) {
            randomList[i] = random.nextInt(n);
        }
        return randomList;
    }

    // The case with the least swaps is already sorted array
    public static int[] generateCaseB(int n) {
        int[] arr = new int[n];
        for (int i =0; i < n; i++) {
            arr[i] = i * 2;
        }
        return arr;
    }

    // the most swaps are when the list in reversed order
    public static int[] generateCaseA(int n) {
        int[] arr = new int[n];
        for (int i =0; i < n; i++) {
            arr[i] =  (n - i) * 2;
        }
        return arr;
    }

    public static void selection_sort(int[] array) {
        int min_index;
        int temp;

        for (int i = 0; i < array.length; i++) {
            min_index = i;
            for (int y = i; y < array.length; y++) {
                if (array[min_index] > array[y]) {
                    min_index = y;
                }
            }
            temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
    }
}