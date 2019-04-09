package com.zhangliang.leetcode;
/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Example 1:

Input: [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
Example 2:

Input: [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
             The third child gets 1 candy because it satisfies the above two conditions.
*/

public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null) {
            return 0;
        }

        int[] candies = new int[ratings.length];

        candies[0] = 1;
        int count = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            candies[i] = count;
        }

        count = 0;
        for (int i = ratings.length - 1; i >= 1; i--) {
            if (ratings[i - 1] > ratings[i]) {
                count++;
            } else {
                count = 0;
            }

            candies[i] += count;
        }

        // sum to ans
        int ans = 0;
        for (int x : candies) {
            ans += x;
        }

        return ans;
    }
}
