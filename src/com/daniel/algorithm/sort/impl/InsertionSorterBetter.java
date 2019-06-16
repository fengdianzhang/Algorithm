package com.daniel.algorithm.sort.impl;

import com.daniel.algorithm.sort.Sorter;

public class InsertionSorterBetter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;
            while (j > 0 && key < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }
}
