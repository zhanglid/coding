package com.zhangliang.leetcode;
/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], 
return its missing ranges.

Example:

Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

*/

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    private String getRangeString(int start, int end) {
        if (start == end) {
            return Integer.toString(start);
        }
        return Integer.toString(start) + "->" + Integer.toString(end);
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans = new ArrayList<>();
        if (nums == null || lower >= upper) {
            return ans;
        }

        int cur = lower;
        for (int i = 0; i < nums.length; i++) {
            if (cur == nums[i]) {
                cur++;
                continue;
            } else {
                ans.add(getRangeString(cur, nums[i] - 1));
                cur = nums[i] + 1;
            }
        }
        if (cur != upper) {
            ans.add(getRangeString(cur, upper));
        }
        return ans;
    }
}
