package com.zhangliang.leetcode;
/*
Given an array nums sorted in ascending order, return true if and only if you can split it into 1 or more subsequences such that each subsequence consists of consecutive integers and has length at least 3.

 

Example 1:

Input: [1,2,3,3,4,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3
3, 4, 5

Example 2:

Input: [1,2,3,3,4,4,5,5]
Output: True
Explanation:
You can split them into two consecutive subsequences : 
1, 2, 3, 4, 5
3, 4, 5

Example 3:

Input: [1,2,3,4,4,5]
Output: False
 

Constraints:

1 <= nums.length <= 10000
 

Accepted
32,063
Submissions
75,111
*/

import java.util.*;

/**
 * Greedy + DP, Time: O(n)
 */
public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, List<Integer>> dp = new HashMap<>();
        for (int num : nums) {
            if (!dp.containsKey(num)) {
                dp.put(num, new ArrayList<>());
                dp.get(num).add(0);
                dp.get(num).add(0);
                dp.get(num).add(0);
            }
            if (dp.containsKey(num - 1)) {
                if (dp.get(num - 1).get(0) > 0) {
                    dp.get(num - 1).set(0, dp.get(num - 1).get(0) - 1);
                    dp.get(num).set(1, dp.get(num).get(1) + 1);
                    continue;
                }
                if (dp.get(num - 1).get(1) > 0) {
                    dp.get(num - 1).set(1, dp.get(num - 1).get(1) - 1);
                    dp.get(num).set(2, dp.get(num).get(2) + 1);
                    continue;
                }
                if (dp.get(num - 1).get(2) > 0) {
                    dp.get(num - 1).set(2, dp.get(num - 1).get(2) - 1);
                    dp.get(num).set(2, dp.get(num).get(2) + 1);
                    continue;
                }
            }
            dp.get(num).set(0, dp.get(num).get(0) + 1);
        }

        for (int key : dp.keySet()) {
            if (dp.get(key).get(0) > 0 || dp.get(key).get(1) > 0) {
                return false;
            }
        }
        return true;

    }
}
