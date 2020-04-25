package com.zhangliang.leetcode;
/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up:
What if the input numbers come in one by one as an infinite stream? In other words, you can't store all 
numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
*/

public class MaxConsecutiveOnesII {
    public int findMaxConsecutiveOnes(int[] nums) {
        int nonFlipCount = 0;
        int flipCount = 0;
        int ans = 0;
        for (int num : nums) {
            if (num == 0) {
                flipCount = nonFlipCount + 1;
                nonFlipCount = 0;
            } else {
                flipCount++;
                nonFlipCount++;
            }
            ans = Math.max(ans, flipCount);
        }
        return ans;
    }
}
