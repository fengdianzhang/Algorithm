package com.daniel.algorithm.sort.impl;

import com.daniel.algorithm.sort.Sorter;

public class HeapSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            sink(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            sink(arr, 0, i);
        }
    }

    private void sink(int[] arr, int i, int size) {
        int j;
        while ((j = i * 2 + 1) < size) {
            if (j + 1 < size && arr[j + 1] > arr[j]) {
                j++;
            }
            if (arr[i] >= arr[j])
                break;
            swap(arr, i, j);
            i = j;
        }
    }
}
