package org.example.NonComparisonSorting;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.*;

public class BucketSort {
    public static void main(String[] args) {
        double [] arr = {0.9, 0.1, 0.6, 0.7, 0.6, 0.3, 0.1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(double [] array) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (double num : array) {
            maxVal = (int) Math.max(maxVal, num);
            minVal = (int) Math.min(minVal, num);
        }

        int rangeVal = maxVal - minVal + 1;

        // Determine the number of buckets and their size
        int bucketSize = 10;
        // Adjust according to the range of values and the size of the input array
        int numBuckets = (int) Math.ceil((double) rangeVal / bucketSize);

        List<Double>[] arrays = new ArrayList[numBuckets];

        for (int i = 0; i < numBuckets; i++) {
            arrays[i] = new ArrayList<>();
        }

        int place;

        for (int i = 0; i < array.length; i++) {
            place = (int) (array[i] - minVal) / bucketSize;

            arrays[place].add(array[i]);
        }

        for (int i =0; i < arrays.length; i++) {
            // Implements built-in sort function
            Collections.sort(arrays[i]);
        }

        int index = 0;
        for (int i = 0; i < arrays.length; i++) {
            for (int y = 0; y < arrays[i].size(); y++) {
                array[index] = arrays[i].get(y);
                index++;
            }
        }
    }
}
