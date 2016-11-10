package com.fdz.algo.sort;

/**
 * Created by fengdianzhang on 16/11/6.
 */
public class Shell extends Sorter{

    @Override
    public void sort(int[] a) {
        int h = 1;
        while (h < a.length / 3) {
            h = 3 * h + 1; //1,4,13,40,121,363...
        }
        while (h >= 1) {
            for (int i = h; i < a.length; i++) {
                for (int j = i; j >= h && a[j - h] > a[j]; j -= h) {
                    swap(a, j, j - h);
                }
            }
            h /= 3;
        }
    }
}
