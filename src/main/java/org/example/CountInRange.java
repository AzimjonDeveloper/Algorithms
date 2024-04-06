package org.example;

import java.util.*;

public class CountInRange {
    public static void main(String[] args) {

        int[] arrCounting = {9, 1, 6, 7, 6, 2, 2, 1};

        System.out.println(countFromRange(arrCounting, 9, 1, 1));

        System.out.println(Arrays.toString(arrCounting));
    }

    public static int countFromRange(int[] arr, int k, int from, int to) {
        int[] count = new int[k + 1];

        for (int i = 1; i <= k; i++) {
            count[i] = 0;
        }

        for (int j : arr) {
            count[j] += 1;
        }

        int counter = 0;

        for (int i = from; i <= to; i++) {
            counter += count[i];
        }

        return counter;
    }
}
