package com.daniel.algorithm.sort.impl;


import com.daniel.algorithm.sort.Sorter;

public class MergeSorter implements Sorter {
    // 也可以不用成员变量，sort 和 merge 方法都加个参数传进去就可以了
    private int[] aux;

    @Override
    public void sort(int[] arr) {
        aux = new int[arr.length];
        sort(arr, 0, arr.length - 1);
        aux = null;
    }

    private void sort(int[] arr, int lo, int hi) {
        if (lo < hi) {
            // 或者 mid = lo + (hi - lo) / 2，防止溢出
            int mid = (lo + hi) >>> 1;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    private void merge(int[] arr, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //noinspection ManualArrayCopy
        for (int k = lo; k <= hi; k++) {
            aux[k] = arr[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                arr[k] = aux[j++];
            } else if (j > hi) {
                arr[k] = aux[i++];
            } else if (aux[i] < aux[j]) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }
    }
}
