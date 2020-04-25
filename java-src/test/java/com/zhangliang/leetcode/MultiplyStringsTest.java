package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MultiplyStringsTest {

    @Test
    public void testCase() {
        MultiplyStrings s = new MultiplyStrings();
        String ans = s.multiply("2", "3");
        assertEquals("6", ans);
    }

    @Test
    public void testCase2() {
        MultiplyStrings s = new MultiplyStrings();
        String ans = s.multiply("123", "456");
        assertEquals("56088", ans);
    }

    @Test
    public void errCase() {
        MultiplyStrings s = new MultiplyStrings();
        String ans = s.multiply("0", "0");
        assertEquals("0", ans);
    }
}
