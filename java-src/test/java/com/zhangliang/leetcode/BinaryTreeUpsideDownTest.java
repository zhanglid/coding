package com.zhangliang.leetcode;

import static org.junit.Assert.assertTrue;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeUpsideDownTest {

    @Test
    public void testCase() {
        BinaryTreeUpsideDown s = new BinaryTreeUpsideDown();
        TreeNode ans = s.upsideDownBinaryTree(new TreeNode(new Integer[] { 1, 2, 3, 4, 5 }));
        TreeNode expected = new TreeNode(new Integer[] { 4, 5, 2, null, null, 3, 1 });
        assertTrue(expected.equals(ans));
    }
}
