package org.example.Sorting;

public class HeapSort {
    public static void maxHeapify(int[] array, int root, int heapSize) {
        int left = root * 2;
        int right = root * 2 + 1;
        int largest = root;

        if (left <= heapSize && array[left] >= array[root]) {
            largest = left;
        }
        if(right <= heapSize && array[right] >= array[largest]) {
            largest = right;
        }
        if(largest != root) {
            //Swaps ROOT and Largest Value
            int temp = array[root];
            array[root] = array[largest];
            array[largest] = temp;

            maxHeapify(array, largest, heapSize);
        }
    }

    static void heapSort(int[] array) {
        int heapSize = array.length - 1;

        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            maxHeapify(array, i, heapSize);
        }
        for (int i = array.length; i >= 1; i--) {
            int temp = array[0];
            array[0] = array[heapSize];
            array[heapSize] = temp;

            heapSize--;
            maxHeapify(array, 0, heapSize);
        }

    }

    public static void main(String [] args) {
        int[] array = {23,4,3,43,4,34,4,3,4,34,3,43,5,67,34,3,64,45,5};

        heapSort(array);

        for (int num: array) {
            System.out.print(num + ", ");
        }
    }
}
