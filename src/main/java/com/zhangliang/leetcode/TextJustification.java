package com.zhangliang.leetcode;
/*Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters 
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
             Note that the second line is also left-justified becase it contains only one word.
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

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    private String getSpaces(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        if (words == null || words.length < 1 || maxWidth < 1) {
            return ans;
        }

        List<String> line = new ArrayList<>();
        int curSize = 0;
        for (String word : words) {
            if (curSize > 0 && curSize + 1 + word.length() > maxWidth) {
                // move to next line
                int extraSpaceSize = maxWidth - curSize + (line.size() - 1);
                int wordsCount = line.size();
                int padSize = wordsCount == 1 ? extraSpaceSize
                        : (int) Math.ceil((float) extraSpaceSize / (wordsCount - 1));
                int fullPadCount = wordsCount == 1 ? 1 : extraSpaceSize % (wordsCount - 1);
                if (fullPadCount == 0) {
                    fullPadCount = wordsCount;
                }
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < Math.max(1, wordsCount - 1); i++) {
                    sb.append(line.get(i));
                    if (i < fullPadCount) {
                        sb.append(getSpaces(padSize));
                    } else {
                        sb.append(getSpaces(padSize - 1));
                    }
                }

                if (wordsCount != 1) {
                    sb.append(line.get(line.size() - 1));
                }

                ans.add(sb.toString());
                line.clear();
                line.add(word);
                curSize = word.length();
            } else {
                // append and update size
                curSize += word.length() + (line.isEmpty() ? 0 : 1);
                line.add(word);
            }
        }

        StringBuilder lastLineBuilder = new StringBuilder();
        for (String s : line) {
            lastLineBuilder.append(s);
            lastLineBuilder.append(' ');
        }
        while (lastLineBuilder.length() < maxWidth) {
            lastLineBuilder.append(' ');
        }

        if (lastLineBuilder.length() > maxWidth) {
            lastLineBuilder.deleteCharAt(lastLineBuilder.length() - 1);
        }
        ans.add(lastLineBuilder.toString());
        return ans;
    }
}
