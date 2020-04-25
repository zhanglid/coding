package com.zhangliang.leetcode;
/*
Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.

Note:
1 <= hand.length <= 10000
0 <= hand[i] <= 10^9
1 <= W <= hand.length
*/

import java.util.*;

public class HandOfStraights {
    public boolean isNStraightHand(int[] nums, int W) {
        if (nums.length % W != 0) {
            return false;
        }
        if (W <= 1) {
            return true;
        }
        Arrays.sort(nums);
        int unresolvedCount = 0;
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();
        for (int num : nums) {
            if (!dp.containsKey(num)) {
                dp.put(num, new HashMap<>());
            }
            if (dp.containsKey(num - 1)) {
                boolean hasPrev = false;
                for (int w = 0; w < W - 1; w++) {
                    if (dp.get(num - 1).getOrDefault(w, 0) > 0) {
                        dp.get(num - 1).put(w, dp.get(num - 1).get(w) - 1);
                        if (dp.get(num))
                            dp.get(num).put(w + 1, dp.get(num).getOrDefault(w + 1, 0) + 1);
                        if (w + 1 == W - 1) {
                            unresolvedCount--;
                            dp.get(num).remove(W - 1);
                        }
                        hasPrev = true;
                        break;
                    }
                }
                if (hasPrev) {
                    continue;
                }
                dp.remove(num - 1);
            }
            dp.get(num).put(0, dp.get(num).getOrDefault(0, 0) + 1);
            unresolvedCount++;
        }
        return unresolvedCount == 0;
    }
}
