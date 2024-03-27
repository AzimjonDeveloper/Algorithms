package org.example.Sorting;

public class InsertionSort {
        public void insertion_sort(int[] numbers) {
            int temp;
            int j;
            for (int i = 1; i < 5; i++) {
                temp = numbers[i];
                j = i - 1;
                while (j >= 0 && numbers[j] > temp) {
                    numbers[j + 1] = numbers[j];
                    j -= 1;
                }
                numbers[j+ 1] = temp;
            }
        }
}
