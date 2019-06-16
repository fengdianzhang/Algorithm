package com.daniel.algorithm.sort.impl;

import com.daniel.algorithm.sort.Sorter;

public class ShellSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        int h = arr.length / 2;
        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                int key = arr[i];
                int j = i;
                while (j >= h && arr[j - h] > key) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                arr[j] = key;
            }
            h /= 2;
        }
    }
}
