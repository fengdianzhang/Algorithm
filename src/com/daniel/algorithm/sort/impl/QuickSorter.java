package com.daniel.algorithm.sort.impl;

import com.daniel.algorithm.sort.Sorter;

public class QuickSorter implements Sorter {

    @Override
    public void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int lo, int hi) {
        if (hi > lo) {
            int p = partition(arr, lo, hi);
            sort(arr, lo, p - 1);
            sort(arr, p + 1, hi);
        }
    }

    private int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        int pivot = arr[lo];
        while (true) {
            while (arr[++i] < pivot) if (i == hi) break;
            while (arr[--j] > pivot) if (j == lo) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, lo, j);
        return j;
    }
}
