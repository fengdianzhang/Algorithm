package com.daniel.algorithm.sort;

import com.daniel.algorithm.Item;
import com.daniel.algorithm.Utils;
import com.daniel.algorithm.sort.impl.ArraysSorter;
import com.daniel.algorithm.sort.impl.QuickSorter;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SorterTester {

    private static final int ITEM_SIZE = 20;
    private int[] items;

    @Before
    public void prepare() {
        items = Utils.generateItems(ITEM_SIZE);
    }

    @Test
    public void arraysSorterTest() {
        sorterTest(ArraysSorter.class);
    }

    @Test
    public void quickSorterTest() {
        sorterTest(QuickSorter.class);
    }

    @After
    public void clear() {
        items = null;
    }

    private void sorterTest(Class<? extends Sorter> clazz) {
        System.out.println("---------- Start testing [" + clazz.getSimpleName() + "] ----------");
        System.out.println("Origin: " + Arrays.toString(items));
        Sorter sorter = null;
        try {
            sorter = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't create Sorter instance!");
        }
        sorter.sort(items);
        System.out.println("After: " + Arrays.toString(items));
        Assert.assertTrue(Utils.isSorted(items));
        System.out.println();
    }
}
