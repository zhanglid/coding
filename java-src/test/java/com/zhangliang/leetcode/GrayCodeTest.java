package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class GrayCodeTest {

    @Test
    public void testCase() {
        GrayCode s = new GrayCode();
        List<Integer> ans = s.grayCode(2);
        assertArrayEquals(new Integer[] { 0, 1, 3, 2 }, ans.toArray(new Integer[0]));
    }

    @Test
    public void errCase() {
        GrayCode s = new GrayCode();
        List<Integer> ans = s.grayCode(0);
        assertArrayEquals(new Integer[] { 0 }, ans.toArray(new Integer[0]));
    }
}
