package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class UniqueBinarySearchTreesTest {

    @Test
    public void testCase() {
        UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
        int ans = s.numTrees(3);
        assertEquals(5, ans);
    }
}
