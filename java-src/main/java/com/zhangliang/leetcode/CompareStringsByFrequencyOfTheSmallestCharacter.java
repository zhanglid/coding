package com.zhangliang.leetcode;
/*
Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

 

Example 1:

Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
Example 2:

Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 

Constraints:

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] are English lowercase letters.
*/

import java.util.*;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    private int getValue(String word) {
        if (word.length() == 0) {
            return 0;
        }
        char x = word.charAt(0);
        int count = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) < x) {
                count = 1;
                x = word.charAt(i);
            } else if (word.charAt(i) == x) {
                count++;
            }
        }
        return count;
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) {
                l++;
            } else {
                r--;
            }
        }
        if (nums[l] > target) {
            return l;
        }
        if (nums[r] > target) {
            return r;
        }
        return nums.length;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordValues = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordValues[i] = getValue(words[i]);
        }
        Arrays.sort(wordValues);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int value = getValue(query);
            int index = binarySearch(wordValues, value);
            result[i] = wordValues.length - index;
        }
        return result;
    }
}
