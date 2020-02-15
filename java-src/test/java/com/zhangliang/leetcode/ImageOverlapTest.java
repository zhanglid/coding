package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class ImageOverlapTest {

    @Test
    public void testCase() {
        ImageOverlap s = new ImageOverlap();
        int ans = s.largestOverlap(new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } },
                new int[][] { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } });
        assertEquals(3, ans);
    }
}
