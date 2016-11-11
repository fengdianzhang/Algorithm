package com.fdz.algo.sort;

/**
 * Created by fengdianzhang on 16-11-10.
 */
public class MinPQ {
    private final int[] a;
    private int size = 0;

    public MinPQ(int size) {
        a = new int[size + 1];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.MAX_VALUE;
        }
    }

    public void insert(int v) {
        a[++size] = v;
        swim(size);
    }

    public int min() {
        return a[1];
    }

    public int deleteMin() {
        int min = a[1];
        a[1] = a[size];
        a[size] = Integer.MAX_VALUE;
        sink(1);
        return min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void swim(int k) {
        while (k > 1 && a[k / 2] > a[k]) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (k * 2 <= size) {
            if (k * 2 == size || a[k * 2] < a[k * 2 + 1]) {
                swap(k, k * 2);
                k = k * 2;
            } else {
                swap(k, k * 2 + 1);
                k = k * 2 + 1;
            }
        }
    }

    private void swap(int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
