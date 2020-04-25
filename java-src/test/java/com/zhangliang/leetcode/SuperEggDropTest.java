package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SuperEggDropTest {

    @Test
    public void testCase() {
        SuperEggDrop s = new SuperEggDrop();
        int ans = s.superEggDrop(1, 2);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        SuperEggDrop s = new SuperEggDrop();
        int ans = s.superEggDrop(2, 6);
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        SuperEggDrop s = new SuperEggDrop();
        int ans = s.superEggDrop(3, 14);
        assertEquals(4, ans);
    }
    @Test
    public void errCase() {
        SuperEggDrop s = new SuperEggDrop();
        int ans = s.superEggDrop(3, 15);
        assertEquals(5, ans);
    }
    @Test
    public void errCase2() {
        SuperEggDrop s = new SuperEggDrop();
        int ans = s.superEggDrop(3, 25);
        assertEquals(5, ans);
    }
    @Test
    public void errCase3() {
        SuperEggDrop s = new SuperEggDrop();
        int ans = s.superEggDrop(3, 41);
        assertEquals(6, ans);
    }
}
