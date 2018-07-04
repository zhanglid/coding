package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ReverseWordsInAStringTest {

    @Test
    public void testCase() {
        ReverseWordsInAString s = new ReverseWordsInAString();
        String ans = s.reverseWords("the sky is blue");
        assertEquals(ans, "blue is sky the");
    }
}
