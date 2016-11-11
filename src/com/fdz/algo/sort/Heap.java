package com.fdz.algo.sort;

/**
 * Created by fengdianzhang on 16-11-11.
 */
public class Heap extends Sorter {
    @Override
    public void sort(int[] a) {
        MinPQ pq = new MinPQ(a.length);
        for (int i : a) {
            pq.insert(i);
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = pq.deleteMin();
        }
    }
}
