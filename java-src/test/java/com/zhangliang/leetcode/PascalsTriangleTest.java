package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import com.zhangliang.Utils;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PascalsTriangleTest {

    @Test
    public void testCase() {
        PascalsTriangle s = new PascalsTriangle();
        List<List<Integer>> ans = s.generate(5);
        String[] expected = new String[] { "[1]", "[1, 1]", "[1, 2, 1]", "[1, 3, 3, 1]", "[1, 4, 6, 4, 1]" };
        assertArrayEquals(expected, Utils.getStrsFrom2DList(ans, false));
    }
}
