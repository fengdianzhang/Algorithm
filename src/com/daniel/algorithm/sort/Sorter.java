package com.daniel.algorithm.sort;

public interface Sorter {

    void sort(int[] arr);

    default void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}
