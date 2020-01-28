package com.zhangliang.leetcode;

/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:
add(1); add(3); add(5);
find(4) -> true
find(7) -> false

Example 2:
add(3); add(1); add(2);
find(3) -> true
find(6) -> false
*/

import java.util.*;

public class TwoSumIII {
    class Num implements Comparable<Num> {
        int id;
        int value;

        public Num(int value, int id) {
            this.value = value;
            this.id = id;
        }

        public int compareTo(Num other) {
            int diff = value - other.value;
            return diff == 0 ? id - other.id : diff;
        }
    }

    TreeSet<Num> ts = new TreeSet<>();

    public TwoSumIII() {

    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        ts.add(new Num(number, ts.size()));
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator<Num> ascIter = ts.iterator();
        Iterator<Num> descIter = ts.descendingIterator();
        if (!ascIter.hasNext()) {
            return false;
        }
        Num a = ascIter.next();
        Num b = descIter.next();
        while (a.id != b.id) {
            if (a.value + b.value < value) {
                a = ascIter.next();
            } else if (a.value + b.value == value) {
                return true;
            } else {
                b = descIter.next();
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such: TwoSum obj = new
 * TwoSum(); obj.add(number); boolean param_2 = obj.find(value);
 */