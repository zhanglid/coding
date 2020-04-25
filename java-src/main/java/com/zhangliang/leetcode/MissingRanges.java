package com.zhangliang.leetcode;
/*
Given a sorted integer array nums, where the range of elements are in the inclusive range 
[lower, upper], 
return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

*/

import java.util.*;

public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int val = lower;
        for (int num : nums) {
            if (num > val) {
                if (num == val + 1) {
                    result.add("" + val);
                } else if (num >= val) {
                    result.add(val + "->" + (num - 1));
                }
            }
            val = num + 1;
            if (val < num) {
                return result;
            }
        }
        if (val <= upper) {
            if (upper == val) {
                result.add("" + val);
            } else if (upper > val) {
                result.add(val + "->" + upper);
            }
        }
        return result;
    }
}
