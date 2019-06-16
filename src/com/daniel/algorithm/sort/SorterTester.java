package com.daniel.algorithm.sort;

import com.daniel.algorithm.Utils;
import com.daniel.algorithm.sort.impl.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SorterTester {

    private static final int ITEM_SIZE = 10000;
    private int[] items;

    @Before
    public void prepare() {
        items = Utils.generateItems(ITEM_SIZE);
    }

    @Test
    public void bubbleSorterTest() {
        sorterTest(BubbleSorter.class);
    }

    @Test
    public void selectionSorterTest() {
        sorterTest(SelectionSorter.class);
    }

    @Test
    public void insertionSorterTest() {
        sorterTest(InsertionSorter.class);
        sorterTest(InsertionSorterBetter.class);
    }

    @Test
    public void shellSorterTest() {
        sorterTest(ShellSorter.class);
        sorterTest(ShellSorterBetter.class);
    }

    @Test
    public void mergeSorterTest() {
        sorterTest(MergeSorter.class);
    }

    @Test
    public void quickSorterTest() {
        sorterTest(QuickSorter.class);
    }

    @Test
    public void heapSorterTest() {
        sorterTest(HeapSorter.class);
    }

    @After
    public void clear() {
        items = null;
    }

    private void sorterTest(Class<? extends Sorter> clazz) {
        System.out.println("---------- Start testing [" + clazz.getSimpleName() + "] ----------");
        int[] copy = Arrays.copyOf(items, items.length);
        final long start = System.currentTimeMillis();
        Sorter sorter;
        try {
            sorter = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException("Can't create Sorter instance!");
        }
        sorter.sort(copy);
        long spent = System.currentTimeMillis() - start;
        boolean sorted = Utils.isSorted(copy);
        if (sorted) {
            System.out.println("Success: " + spent + " ms spent.");
        } else {
            System.out.println("Failed!");
            System.out.println("Origin: " + Arrays.toString(items));
            System.out.println("After: " + Arrays.toString(copy));
            Assert.fail();
        }
    }
}
