package com.zhangliang.utils;

public class ArrayReader {
    private static final int MAX_SIZE = 10000;
    private int[] nums;

    public ArrayReader(int[] nums) {
        this.nums = nums.clone();
    }

    public int get(int x) {
        if (x >= ArrayReader.MAX_SIZE || x >= nums.length) {
            return Integer.MAX_VALUE;
        }
        return nums[x];
    }
}
