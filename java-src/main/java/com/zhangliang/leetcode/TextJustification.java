package com.zhangliang.leetcode;
/*
Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters 
and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces 
' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not 
divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified because it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
*/

import java.util.*;

public class TextJustification {
    class LineBuilder {
        int maxWidth;
        // Total length of the built line.
        int totalLength;
        // Length of total words.
        int wordsLength;
        // Words in this line.
        List<String> words = new ArrayList<>();

        public LineBuilder(int maxWidth) {
            this.maxWidth = maxWidth;
        }

        public void addWord(String word) {
            if (hasSpaceForWord(word)) {
                words.add(word);
                if (totalLength > 0) {
                    totalLength += 1;
                }
                totalLength += word.length();
                wordsLength += word.length();
            }
        }

        public boolean hasSpaceForWord(String word) {
            return ((totalLength > 0 ? 1 : 0) + totalLength) + word.length() <= maxWidth;
        }

        private String buildSpace(int count) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < count; i++) {
                sb.append(" ");
            }
            return sb.toString();
        }

        public String build(boolean isLastLine) {
            int totalSpaceNum = maxWidth - wordsLength;
            int largeSpaceNum = isLastLine ? 0 : totalSpaceNum % (Math.max(1, words.size() - 1));
            int spaceWidth = isLastLine ? 1 : totalSpaceNum / Math.max(1, (words.size() - 1));
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (sb.length() >= 1) {
                    sb.append(buildSpace(spaceWidth + (largeSpaceNum == 0 ? 0 : 1)));
                    if (largeSpaceNum > 0) {
                        largeSpaceNum--;
                    }
                }
                sb.append(word);
            }
            while (sb.length() < maxWidth) {
                sb.append(buildSpace(1));
            }
            return sb.toString();
        }
    }

    public List<String> fullJustify(final String[] words, final int maxWidth) {
        List<String> result = new ArrayList<>();
        LineBuilder lb = new LineBuilder(maxWidth);
        for (String word : words) {
            if (!lb.hasSpaceForWord(word)) {
                result.add(lb.build(false));
                lb = new LineBuilder(maxWidth);
            }
            lb.addWord(word);
        }
        if (lb.words.size() > 0) {
            result.add(lb.build(true));
        }
        return result;
    }
}
