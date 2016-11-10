package com.fdz.algo.sort;

/**
 * Created by fengdianzhang on 16-11-4.
 */
public class Insertion2 extends Sorter {
    @Override
    public void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int j, tmp = a[i];
            for (j = i; j > 0 && a[j - 1] > tmp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = tmp;
        }
    }
}
