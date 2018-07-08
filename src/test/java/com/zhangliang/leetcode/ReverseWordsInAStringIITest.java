package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ReverseWordsInAStringIITest {

    @Test
    public void testCase() {
        ReverseWordsInAStringII s = new ReverseWordsInAStringII();
        char[] chars = new char[] { 't', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e' };
        s.reverseWords(chars);
        char[] expected = new char[] { 'b', 'l', 'u', 'e', ' ', 'i', 's', ' ', 's', 'k', 'y', ' ', 't', 'h', 'e' };
        assertArrayEquals(expected, chars);
    }
}
