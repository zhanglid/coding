package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AddBinaryTest {

    @Test
    public void testCase() {
        AddBinary s = new AddBinary();
        String ans = s.addBinary("11", "1");
        assertEquals("100", ans);
    }

    @Test
    public void testCase2() {
        AddBinary s = new AddBinary();
        String ans = s.addBinary("1010", "1011");
        assertEquals("10101", ans);
    }
}
