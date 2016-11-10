package com.fdz.algo.sort;

/**
 * Created by fengdianzhang on 16-11-4.
 */
public class Selection extends Sorter {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            swap(a, i, min);
        }
    }
}
