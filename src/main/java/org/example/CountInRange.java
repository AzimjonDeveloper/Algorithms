package org.example;

public class CountInRange {
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
