package com.daniel.algorithm;

import java.util.Random;

public class Utils {
    private static final int bound = 100;
    private static Random random;

    private static Random getRandom() {
        if (random == null) {
            synchronized (Utils.class) {
                random = new Random();
            }
        }
        return random;
    }

    public static int[] generateItems(int count) {
        int[] items = new int[count];
        Random r = getRandom();
        for (int i = 0; i < count; i++) {
            items[i] = r.nextInt(bound);
        }
        return items;
    }

    public static boolean isSorted(int[] items) {
        if (items == null) {
            throw new NullPointerException("Items is NULL!");
        }
        for (int i = 1; i < items.length; i++) {
            if (items[i] < items[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
