package com.zhangliang.leetcode;
/*
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
Note: The result may be very large, so you need to return a string instead of an integer.
*/

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return "";
        }

        Integer[] converted = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            converted[i] = nums[i];
        }

        Arrays.sort(converted, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                String bStr = b.toString();
                String aStr = a.toString();
                return (bStr + aStr).compareTo(aStr + bStr);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Integer value : converted) {
            sb.append(value.toString());
        }
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
