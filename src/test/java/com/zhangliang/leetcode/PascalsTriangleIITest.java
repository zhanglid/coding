package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class PascalsTriangleIITest {

    @Test
    public void testCase() {
        PascalsTriangleII s = new PascalsTriangleII();
        List<Integer> ans = s.getRow(3);
        assertArrayEquals(new Integer[] { 1, 3, 3, 1 }, ans.toArray(new Integer[0]));
    }
}
