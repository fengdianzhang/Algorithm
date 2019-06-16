package com.daniel.algorithm.sort.impl;

import com.daniel.algorithm.sort.Sorter;

public class InsertionSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 从后往前交换可以减少比较的次数
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }
}
