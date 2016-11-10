package com.fdz.algo.sort;

/**
 * Created by fengdianzhang on 16-11-4.
 */
public class Insertion extends Sorter {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
                swap(a, j, j - 1);
            }
        }
    }
}
