package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class MinimumDepthOfBinaryTreeTest {

    @Test
    public void testCase() {
        MinimumDepthOfBinaryTree s = new MinimumDepthOfBinaryTree();
        int ans = s.minDepth(new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
        assertEquals(2, ans);
    }

    @Test
    public void errCase() {
        MinimumDepthOfBinaryTree s = new MinimumDepthOfBinaryTree();
        int ans = s.minDepth(new TreeNode(new Integer[] { 1, 2 }));
        assertEquals(2, ans);
    }

    @Test
    public void errCase2() {
        MinimumDepthOfBinaryTree s = new MinimumDepthOfBinaryTree();
        int ans = s.minDepth(null);
        assertEquals(0, ans);
    }
}
