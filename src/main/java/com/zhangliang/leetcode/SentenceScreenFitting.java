package com.zhangliang.leetcode;
/*
Given a rows x cols screen and a sentence represented by a list of 
non-empty words, find how many times the given sentence can be fitted 
on the screen.

Note:

A word cannot be split into two lines.
The order of words in the sentence must remain unchanged.
Two consecutive words in a line must be separated by a single space.
Total words in the sentence won't exceed 100.
Length of each word is greater than 0 and won't exceed 10.
1 ≤ rows, cols ≤ 20,000.

Example 1:

Input:
rows = 2, cols = 8, sentence = ["hello", "world"]

Output: 
1

Explanation:
hello---
world---

The character '-' signifies an empty space on the screen.
Example 2:

Input:
rows = 3, cols = 6, sentence = ["a", "bcd", "e"]

Output: 
2

Explanation:
a-bcd- 
e-a---
bcd-e-

The character '-' signifies an empty space on the screen.
Example 3:

Input:
rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]

Output: 
1

Explanation:
I-had
apple
pie-I
had--

The character '-' signifies an empty space on the screen.
*/

import java.util.Arrays;

public class SentenceScreenFitting {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        if (sentence == null || sentence.length < 1 || rows <= 0 || cols <= 0) {
            return 0;
        }

        int[] colJump = new int[cols];
        int[] rowJump = new int[cols];

        for (int i = 0; i < cols; i++) {
            int rowCount = 0;
            int si = i - 1;
            for (String s : sentence) {
                if (si != 0) si++;
                if (si == cols) {
                    si = 0;
                    rowCount++;
                }
                if (si + s.length() > cols) {
                    rowCount++;
                    si = s.length();
                    if (si > cols) {
                        return 0;
                    }
                    if (si == cols) {
                        rowCount++;
                        si = 0;
                    }
                } else if (si + s.length() == cols) {
                    rowCount++;
                    si = 0;
                } else {
                    si += s.length();
                }
            }

            colJump[i] = si;
            rowJump[i] = rowCount;
        }

        int ans = 0;

        int row = 0;
        int col = 0;

        int[] prevRow = new int[cols];
        int[] prevCount = new int[cols];
        Arrays.fill(prevRow, -1);
        Arrays.fill(prevCount, -1);
        while (row < rows) {
            if (col != 0) {
                col++;
            }
            if (col >= cols) {
                row++;
                col = 0;
                if (row >= rows) {
                    break;
                }
            }

            if (prevRow[col] > 0) {
                int rowDiff = row - prevRow[col];
                int countDiff = ans - prevCount[col];
                while (row + countDiff < rows) {
                    row += rowDiff;
                    ans += countDiff;
                }
            }
            if (prevRow[col] < 0) {
                prevCount[col] = ans;
                prevRow[col] = row;
            }
            if (row + rowJump[col] > rows || row + rowJump[col] == rows && colJump[col] > 0) {
                break;
            }
            row += rowJump[col];
            col = colJump[col];
            ans++;
        }

        return ans;
    }
}
