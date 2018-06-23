package com.zhangliang.leetcode;
/*
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
*/

public class SingleNumberII {
    private int[] getBits(int num) {
        int[] ans = new int[32];
        for (int i = 0; i < 32; i++) {
            ans[i] = num % 2;
            num = num >> 1;
        }

        return ans;
    }

    private int getNumber(int[] bits) {
        int base = 1;

        int ans = 0;

        for (int i = 0; i < bits.length; i++) {
            ans += base * bits[i];
            base = base << 1;
        }

        return ans;
    }

    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int[] bitsCounter = new int[32];
        for (int num : nums) {
            int[] bits = getBits(num);
            for (int i = 0; i < 32; i++) {
                bitsCounter[i] += bits[i];
                bitsCounter[i] %= 3;
            }
        }

        return getNumber(bitsCounter);
    }
}
