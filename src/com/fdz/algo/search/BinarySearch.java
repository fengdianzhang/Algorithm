package com.fdz.algo.search;
/**
 * Created by fengdianzhang on 16-11-3.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 8, 9, 11, 15};
        System.out.println(rank(15, a));
    }

    public static int rank(int key, int[] a) {
        int lo = 0, hi = a.length - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid - 1;
            } else if (a[mid] < key) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
