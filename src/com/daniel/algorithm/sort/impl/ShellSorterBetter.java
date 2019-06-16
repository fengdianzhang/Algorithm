package com.daniel.algorithm.sort.impl;

import com.daniel.algorithm.sort.Sorter;

public class ShellSorterBetter implements Sorter {
    @Override
    public void sort(int[] arr) {
        int h = 1;
        while (h < arr.length / 3) {
            h = h * 3 + 1;
        }
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
            h /= 3;
        }
    }
}
