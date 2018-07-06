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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumIII {
    /** Initialize your data structure here. */
    private List<Integer> list;

    public TwoSumIII() {
        list = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int index = Collections.binarySearch(list, number);
        if (index < 0) {
            index = -index;
            index -= 1;
        }

        list.add(index, number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int l = 0;
        int r = list.size() - 1;

        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum < value) {
                l++;
            } else if (sum == value) {
                return true;
            } else {
                r--;
            }
        }

        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such: TwoSum obj = new
 * TwoSum(); obj.add(number); boolean param_2 = obj.find(value);
 */