package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RangeModuleTest {

    @Test
    public void testCase() {
        RangeModule s = new RangeModule();
        s.addRange(10, 20);
        s.removeRange(14, 16);
        boolean ans = s.queryRange(10, 14);
        assertEquals("first", true, ans);
        ans = s.queryRange(13, 15);
        assertEquals("second", false, ans);
        ans = s.queryRange(16, 17);
        assertEquals("third", true, ans);
    }

    @Test
    public void testCase2() {
        RangeModule s = new RangeModule();
        s.addRange(10, 180);
        s.addRange(150, 200);
        s.addRange(250, 500);
        boolean ans = s.queryRange(50, 100);
        assertEquals(true, ans);
    }

    @Test
    public void errCase() {
        RangeModule s = new RangeModule();
        s.addRange(6, 8);
        s.removeRange(7, 8);
        s.removeRange(8, 9);
        s.addRange(8, 9);
        s.removeRange(1, 3);
        s.addRange(1, 8);
        boolean ans = s.queryRange(2, 9);
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        RangeModule s = new RangeModule();
        boolean ans = s.queryRange(2, 9);
        assertEquals(false, ans);
    }

    @Test
    public void errCase3() {
        RangeModule s = new RangeModule();
        s.addRange(44, 53);
        s.addRange(69, 89);
        s.removeRange(86, 91);
        s.addRange(87, 94);
        s.removeRange(34, 52);
        s.addRange(1, 59);
        s.removeRange(62, 96);
        s.removeRange(34, 83);
        boolean ans = s.queryRange(1, 13);
        assertEquals(true, ans);
    }
}
