package com.daniel.algorithm.sort.impl;

import com.daniel.algorithm.sort.Sorter;

import java.util.Arrays;

public class ArraysSorter implements Sorter {
    @Override
    public void sort(Comparable<?>[] items) {
        Arrays.sort(items);
    }
}
