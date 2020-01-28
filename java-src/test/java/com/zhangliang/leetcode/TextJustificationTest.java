package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class TextJustificationTest {

    @Test
    public void testCase() {
        TextJustification s = new TextJustification();
        String[] input = new String[] { "This", "is", "an", "example", "of", "text", "justification." };
        List<String> ans = s.fullJustify(input, 16);
        String[] expected = new String[] { "This    is    an", "example  of text", "justification.  " };
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void testCase2() {
        TextJustification s = new TextJustification();
        String[] input = new String[] { "What", "must", "be", "acknowledgment", "shall", "be" };
        List<String> ans = s.fullJustify(input, 16);
        String[] expected = new String[] { "What   must   be", "acknowledgment  ", "shall be        " };
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

    @Test
    public void testCase3() {
        TextJustification s = new TextJustification();
        String[] input = new String[] { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" };
        List<String> ans = s.fullJustify(input, 20);
        String[] expected = new String[] { "Science  is  what we", "understand      well", "enough to explain to",
                "a  computer.  Art is", "everything  else  we", "do                  " };
        assertArrayEquals(expected, ans.toArray(new String[0]));
    }

}
