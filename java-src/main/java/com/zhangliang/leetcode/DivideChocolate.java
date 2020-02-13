package com.zhangliang.leetcode;
/*
You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array sweetness.

You want to share the chocolate with your K friends so you start cutting the chocolate bar into K+1 pieces using K cuts, each piece 
consists of some consecutive chunks.

Being generous, you will eat the piece with the minimum total sweetness and give the other pieces to your friends.

Find the maximum total sweetness of the piece you can get by cutting the chocolate bar optimally.
 

Example 1:

Input: sweetness = [1,2,3,4,5,6,7,8,9], K = 5
Output: 6
Explanation: You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]

Example 2:

Input: sweetness = [5,6,7,8,9,1,2,3,4], K = 8
Output: 1
Explanation: There is only one way to cut the bar into 9 pieces.

Example 3:

Input: sweetness = [1,2,2,1,2,2,1,2,2], K = 2
Output: 5
Explanation: You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
 

Constraints:

0 <= K < sweetness.length <= 10^4
1 <= sweetness[i] <= 10^5
*/

import java.util.*;

public class DivideChocolate {
    private int[] maxDivideNum(int[] nums, int value) {
        int count = 0;
        int sum = 0;
        int minSum = -1;
        for (int num : nums) {
            sum += num;
            if (sum >= value) {
                count++;
                minSum = minSum == -1 ? sum : Math.min(minSum, sum);
                sum = 0;
            }
        }
        return new int[] { count, minSum };
    }

    public int maximizeSweetness(int[] sweetness, int K) {
        if (sweetness.length == 0) {
            return 0;
        }
        int l = 0;
        int r = 0;
        for (int value : sweetness) {
            r += value;
        }
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            int k = maxDivideNum(sweetness, mid)[0] - 1;
            if (K <= k) {
                l = mid;
            } else {
                r = mid;
            }
        }
        int value = r;
        if (maxDivideNum(sweetness, r)[0] - 1 < K) {
            value = l;
        }
        return maxDivideNum(sweetness, value)[1];
    }
}
