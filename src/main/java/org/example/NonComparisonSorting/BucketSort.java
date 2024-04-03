package org.example.NonComparisonSorting;

import java.util.Arrays;
import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {9, 1, 6, 7, 6, 2, 1};

        bucketSort(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void bucketSort(int[] arr) {
        // Find the maximum and minimum values in the array
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int num : arr) {
            maxVal = Math.max(maxVal, num);
            minVal = Math.min(minVal, num);
        }

        // Calculate the range of values
        int rangeVal = maxVal - minVal + 1;

        // Determine the number of buckets and their size
        int bucketSize = 10; // Adjust according to the range of values and the size of the input array
        int numBuckets = (int) Math.ceil((double) rangeVal / bucketSize);

        // Create an array of empty buckets
        ArrayList<Integer>[] buckets = new ArrayList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribute elements into buckets
        for (int num : arr) {
            int index = (num - minVal) / bucketSize;
            buckets[index].add(num);
        }

        // Sort each bucket using Collections.sort (or any other sorting algorithm)
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Concatenate sorted buckets to get the final sorted array
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                arr[index++] = num;
            }
        }
    }



    public static void insertionSort(int [] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];

            int y = i - 1;

            while (y >= 0 && key < arr[y]) {
                arr[y + 1] = arr[y];
                y--;
            }

            arr[y + 1] = key;
        }
    }
}
