package com.zhangliang.leetcode;
/*
Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
*/

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty()) {
            if ((word1 == null || word1.isEmpty() && (word2 == null || word2.isEmpty()))) {
                return 0;
            }

            if (word1 != null && !word1.isEmpty()) {
                return word1.length();
            }

            return word2.length();
        }

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();

        for (int i = 0; i <= chars1.length; i++) {
            for (int j = 0; j <= chars2.length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                    continue;
                }

                if (j == 0) {
                    dp[i][j] = i;
                    continue;
                }

                int removeNum = dp[i - 1][j];
                int insertNum = dp[i][j - 1];
                int replaceNum = dp[i - 1][j - 1];
                dp[i][j] = Math.min(removeNum, insertNum);
                dp[i][j] = Math.min(dp[i][j], replaceNum);
                dp[i][j]++;

                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }

            }
        }

        return dp[word1.length()][word2.length()];
    }
}
