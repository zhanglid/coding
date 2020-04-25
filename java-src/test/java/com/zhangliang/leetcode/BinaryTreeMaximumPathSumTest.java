package com.zhangliang.leetcode;

import static org.junit.Assert.*;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeMaximumPathSumTest {

    @Test
    public void testCase() {
        BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();
        int ans = s.maxPathSum(new TreeNode(new Integer[] { 1, 2, 3 }));
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();
        int ans = s.maxPathSum(new TreeNode(new Integer[] { -10, 9, 20, null, null, 15, 7 }));
        assertEquals(42, ans);
    }
}
