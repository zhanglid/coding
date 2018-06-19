package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class PathSumTest {

    @Test
    public void testCase() {
        PathSum s = new PathSum();
        TreeNode input = new TreeNode(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 });
        boolean ans = s.hasPathSum(input, 22);
        assertEquals(ans, true);
    }
}
