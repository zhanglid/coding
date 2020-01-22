package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
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

    @Test
    public void errCase4() {
        RangeModule s = new RangeModule();
        s.addRange(55, 62);
        s.addRange(1, 29);
        s.removeRange(18, 49);
        s.removeRange(40, 45);
        s.removeRange(4, 58);
        s.removeRange(57, 69);
        s.removeRange(20, 30);
        s.removeRange(1, 40);
        s.removeRange(32, 93);
        s.addRange(38, 100);
        s.removeRange(50, 64);
        s.addRange(26, 72);
        s.addRange(44, 85);
        s.addRange(10, 71);
        s.removeRange(10, 45);
        s.addRange(47, 98);
        s.removeRange(44, 78);
        s.removeRange(31, 49);
        s.addRange(62, 63);
        s.addRange(49, 88);
        s.removeRange(47, 72);
        s.removeRange(8, 50);
        s.removeRange(49, 79);
        s.addRange(31, 47);
        s.addRange(54, 87);
        s.removeRange(25, 86);
        s.removeRange(8, 92);
        s.addRange(90, 95);
        s.addRange(28, 56);
        s.addRange(10, 42);
        s.addRange(75, 81);
        s.addRange(17, 63);
        s.removeRange(78, 90);
        s.addRange(9, 18);
        s.removeRange(20, 54);
        s.addRange(35, 72);
        s.addRange(28, 41);
        s.addRange(17, 95);
        s.addRange(73, 75);
        s.addRange(57, 96);
        s.removeRange(21, 67);
        s.removeRange(40, 73);
        s.removeRange(14, 26);
        s.removeRange(71, 86);
        assertEquals(true, s.queryRange(34, 41));
        s.removeRange(10, 25);
        s.queryRange(27, 68);
        s.queryRange(18, 32);
        s.removeRange(30, 31);
        s.queryRange(45, 61);
        s.addRange(64, 66);
        s.addRange(18, 93);
        s.queryRange(13, 21);
        s.removeRange(13, 46);
        s.removeRange(56, 99);
        s.queryRange(6, 93);
        s.addRange(25, 36);
        s.removeRange(27, 88);
        s.removeRange(82, 83);
        s.addRange(30, 71);
        s.addRange(31, 73);
        s.addRange(10, 41);
        s.queryRange(71, 72);
        s.queryRange(9, 56);
        s.addRange(22, 76);
        s.queryRange(38, 74);
        s.removeRange(2, 77);
        s.queryRange(33, 61);
        s.removeRange(74, 75);
        s.addRange(11, 43);
        s.queryRange(27, 7);
    }

}
