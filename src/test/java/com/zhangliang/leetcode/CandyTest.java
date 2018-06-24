package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CandyTest {

    @Test
    public void testCase() {
        Candy s = new Candy();
        int ans = s.candy(new int[] { 1, 0, 2 });
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        Candy s = new Candy();
        int ans = s.candy(new int[] { 1, 2, 2 });
        assertEquals(4, ans);
    }

    @Test
    public void errCase() {
        Candy s = new Candy();
        int ans = s.candy(new int[] { 1, 3, 2, 2, 1 });
        assertEquals(7, ans);
    }

    @Test
    public void errCase2() {
        Candy s = new Candy();
        int ans = s.candy(new int[] { 1, 2, 87, 87, 87, 2, 1 });
        assertEquals(13, ans);
    }

    @Test
    public void errCase3() {
        Candy s = new Candy();
        int ans = s.candy(new int[] { 1, 3, 4, 5, 2 });
        assertEquals(11, ans);
    }
}
