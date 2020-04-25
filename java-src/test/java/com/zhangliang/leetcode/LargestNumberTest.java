package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LargestNumberTest {

    @Test
    public void testCase() {
        LargestNumber s = new LargestNumber();
        String ans = s.largestNumber(new int[] { 10, 2 });
        assertEquals("210", ans);
    }

    @Test
    public void testCase2() {
        LargestNumber s = new LargestNumber();
        String ans = s.largestNumber(new int[] { 3, 30, 34, 5, 9 });
        assertEquals("9534330", ans);
    }

    @Test
    public void errCase() {
        LargestNumber s = new LargestNumber();
        String ans = s.largestNumber(new int[] { 121, 12 });
        assertEquals("12121", ans);
    }

    @Test
    public void errCase2() {
        LargestNumber s = new LargestNumber();
        String ans = s.largestNumber(new int[] { 0 });
        assertEquals("0", ans);
    }
}
