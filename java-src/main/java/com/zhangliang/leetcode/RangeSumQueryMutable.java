package com.zhangliang.leetcode;
/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.

Example:

Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:

The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.
*/

public class RangeSumQueryMutable {
    private int[] bitArray = null;
    private int[] oriArray = null;

    public RangeSumQueryMutable(int[] nums) {
        if (nums == null) {
            return;
        }
        bitArray = new int[nums.length + 1];
        oriArray = new int[nums.length];
        for (int i = 1; i <= nums.length; i++) {
            update(i - 1, nums[i - 1]);
        }
    }

    // update all affected nodes, get next: 1. 2's complement; 2. AND with original;
    // 3. ADD it to the original
    public void update(int i, int val) {
        int bitIndex = i + 1;
        int delta = val - oriArray[i];
        oriArray[i] = val;
        while (bitIndex < bitArray.length) {
            bitArray[bitIndex] += delta;
            bitIndex += (bitIndex & -bitIndex);
        }
    }

    public int sumRange(int i, int j) {
        return sumRange(j) - sumRange(i - 1);
    }

    // get sum by add the node all the way to the root
    // get parent for bit: 1. 2's complement; 2. AND with original; 3. subtract from
    private int sumRange(int i) {
        int bitIndex = i + 1;
        int sum = 0;
        while (bitIndex > 0) {
            sum += bitArray[bitIndex];
            bitIndex -= bitIndex & -bitIndex;
        }
        return sum;
    }
}
