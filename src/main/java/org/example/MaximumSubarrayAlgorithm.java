package org.example;

public class MaximumSubarrayAlgorithm {
    public static void main(String[] args) {
        int [] arr = {1, -4,  5, 13, 5, -1};
        System.out.println(maxSubBruteForce(arr));

        System.out.println(maxSub(arr, 0, arr.length - 1));
    }

    // Buy - Sell Stocks problem
    // Brute-Force way
    // Time Complexity O(n^2)
    public static int maxSubBruteForce(int[] arr) {
        int max = arr[1] - arr[0];
        for (int i =0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                max = Math.max(max, arr[j] - arr[i]);
            }
        }
        return max;
    }

    //Maximum Subarray problem
    public static int maxSub(int[] arr, int low, int right) {
        if(low == right) {
            return arr[low];
        }
        int mid = (low + right) / 2;

        int maxLeft = maxSub(arr, low, mid);
        int maxRight = maxSub(arr, mid + 1, right);
        int maxCross = maxCross(arr, low, right);

        return Math.max(Math.max(maxLeft, maxRight), maxCross);
    }

    private static int maxCross(int[] arr, int low, int right) {
        int mid = (low + right) / 2;

        int left_sum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            left_sum = Math.max(left_sum, sum);

        }

        int right_sum = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += arr[i];
            right_sum = Math.max(right_sum, sum);
        }
        return left_sum + right_sum;
    }

}
