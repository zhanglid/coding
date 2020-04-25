package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CountAndSayTest {

    @Test
    public void testCase() {
        CountAndSay s = new CountAndSay();
        String ans = s.countAndSay(1);
        assertEquals(ans, "1");
    }

    @Test
    public void testCase2() {
        CountAndSay s = new CountAndSay();
        String ans = s.countAndSay(4);
        assertEquals(ans, "1211");
    }
}
