package com.zhangliang.leetcode;
/*
You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24

Example 2:
Input: [1, 2, 1, 2]
Output: False
Note:
The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
*/

import java.util.*;

public class TwentyFourGame {
    private static final double DELTA = 10e-6;

    private boolean equal(double a, double b) {
        return Math.abs(a - b) < DELTA;
    }

    private boolean canBuild24(double a, double b) {
        boolean result = equal(a + b, 24) || equal(a - b, 24) || equal(b - a, 24) || equal(a * b, 24)
                || b != 0 && equal(a / b, 24) || a != 0 && equal(b / a, 24);
        return result;
    }

    private boolean dfs(double a, double b, boolean[] chosen, int[] nums, int aChosenNum, int bChosenNum) {
        if (aChosenNum + bChosenNum == 4) {
            return canBuild24(a, b);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!chosen[i]) {
                chosen[i] = true;
                int num = nums[i];
                if (aChosenNum < 3) {
                    if (dfs(a + num, b, chosen, nums, aChosenNum + 1, bChosenNum)) {
                        return true;
                    }
                    if (aChosenNum > 0) {
                        if (dfs(a - num, b, chosen, nums, aChosenNum + 1, bChosenNum)) {
                            return true;
                        }
                        if (dfs(num - a, b, chosen, nums, aChosenNum + 1, bChosenNum)) {
                            return true;
                        }
                        if (dfs(a * num, b, chosen, nums, aChosenNum + 1, bChosenNum)) {
                            return true;
                        }
                        if (num != 0 && dfs(a / num, b, chosen, nums, aChosenNum + 1, bChosenNum)) {
                            return true;
                        }
                        if (a != 0 && dfs(num / a, b, chosen, nums, aChosenNum + 1, bChosenNum)) {
                            return true;
                        }
                    }
                }
                if (bChosenNum < 2) {
                    if (dfs(a, b + num, chosen, nums, aChosenNum, bChosenNum + 1)) {
                        return true;
                    }
                    if (bChosenNum > 0) {
                        if (dfs(a, b - num, chosen, nums, aChosenNum, bChosenNum + 1)) {
                            return true;
                        }
                        if (dfs(a, num - b, chosen, nums, aChosenNum, bChosenNum + 1)) {
                            return true;
                        }
                        if (dfs(a, b * num, chosen, nums, aChosenNum, bChosenNum + 1)) {
                            return true;
                        }
                        if (num != 0 && dfs(a, b / num, chosen, nums, aChosenNum, bChosenNum + 1)) {
                            return true;
                        }
                        if (b != 0 && dfs(a, num / b, chosen, nums, aChosenNum, bChosenNum + 1)) {
                            return true;
                        }
                    }
                }
                chosen[i] = false;
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] nums) {
        return dfs(0, 0, new boolean[nums.length], nums, 0, 0);
    }
}
