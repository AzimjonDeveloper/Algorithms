package org.example.DataStructures;

import static org.example.Sorting.HeapSort.maxHeapify;

public class MaxPriorityQueue {
    public int[] heap;
    private int heapSize;
    private static final int DEFAULT_CAPACITY = 10;

    MaxPriorityQueue() {
        heap = new int[DEFAULT_CAPACITY];
        this.heapSize = 0;
    }

    // Time Complexity O(1)
    public int maximum() {
        if (heapSize < 1) {
            throw new RuntimeException("Heap Underflow");
        }
        return heap[0];
    }

    public int extractMax() {
        if (heapSize < 1) {
            throw new RuntimeException("Heap Underflow");
        }
        int max = heap[0];
        heap[0] = heap[heapSize];
        heapSize--;
        maxHeapify(heap, 0, heapSize);

        return max;
    }

    // O(lgN)
    public void increaseKey(int index, int key) {
        if(heap[index] > key) {
            throw new RuntimeException("The key is already larger");
        }
        heap[index] = key;

        while (heap[index / 2] < heap[index] && index > 1) {
            int temp = heap[index];
            heap[index] = heap[index / 2];
            heap[index / 2] = temp;
            index = index / 2;
        }
    }

    public void insert(int key) {
        heapSize++;
        heap[heapSize] = Integer.MIN_VALUE;
        increaseKey(heapSize, key);
    }
}