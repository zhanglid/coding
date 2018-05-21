package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MultiplyStringsTest {

    @Test
    public void testCase() {
        MultiplyStrings s = new MultiplyStrings();
        String ans = s.multiply("2", "3");
        assertEquals(ans, "6");
    }

    @Test
    public void testCase2() {
        MultiplyStrings s = new MultiplyStrings();
        String ans = s.multiply("123", "456");
        assertEquals(ans, "56088");
    }
}
