package com.daniel.algorithm;

import java.util.Arrays;
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

    public static Item[] generateItems(int count) {
        Item[] items = new Item[count];
        Random r = getRandom();
        for (int i = 0; i < count; i++) {
            items[i] = new Item(r.nextInt(bound));
        }
        return items;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] items) {
        if (items == null) {
            throw new NullPointerException("Items is NULL!");
        }
        for (int i = 1; i < items.length; i++) {
            if (items[i].compareTo(items[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }
}
