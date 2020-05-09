package com.zhangliang.google;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class StringTokenizeTest {

    @Test
    public void testCase() {
        StringTokenize s = new StringTokenize();
        String[] ans = s.tokenize("It is 'very good'");
        assertArrayEquals(new String[] { "It", "is", "very good" }, ans);
    }
}
