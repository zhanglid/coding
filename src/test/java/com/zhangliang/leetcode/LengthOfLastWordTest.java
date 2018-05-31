package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LengthOfLastWordTest {

    @Test
    public void testCase() {
        LengthOfLastWord s = new LengthOfLastWord();
        int ans = s.lengthOfLastWord("Hello World");
        assertEquals(5, ans);
    }
}
