package com.daniel.algorithm;

import java.util.Objects;

public class Item implements Comparable<Item>{

    private final int priority;

    public Item(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.valueOf(priority);
    }

    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return priority == item.priority;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(priority);
    }
}
