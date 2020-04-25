package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class LowestCommonAncestorOfABinaryTreeTest {

    @Test
    public void testCase() {
        LowestCommonAncestorOfABinaryTree s = new LowestCommonAncestorOfABinaryTree();
        TreeNode ans = s.lowestCommonAncestor(new TreeNode(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }),
                new TreeNode(5), new TreeNode(1));
        assertEquals(3, ans.val);
    }

    @Test
    public void testCase2() {
        LowestCommonAncestorOfABinaryTree s = new LowestCommonAncestorOfABinaryTree();
        TreeNode ans = s.lowestCommonAncestor(new TreeNode(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 }),
                new TreeNode(5), new TreeNode(4));
        assertEquals(5, ans.val);
    }
}
