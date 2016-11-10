package com.fdz.algo.sort;

/**
 * Created by fengdianzhang on 16/11/6.
 */
public class Merge extends Sorter {
    @Override
    public void sort(int[] a) {
        int[] aux = new int[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    public void sort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    public void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            aux[i] = a[i];
        }
        int i = lo, j = mid + 1, k = lo;
        while (k <= hi) {
            if (i > mid) {
                a[k++] = aux[j++];
            } else if (j > hi) {
                a[k++] = aux[i++];
            } else if (aux[i] < aux[j]) {
                a[k++] = aux[i++];
            } else {
                a[k++] = aux[j++];
            }
        }
    }
}
