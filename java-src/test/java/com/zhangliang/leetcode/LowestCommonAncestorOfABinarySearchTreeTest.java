package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class LowestCommonAncestorOfABinarySearchTreeTest {

    @Test
    public void testCase() {
        LowestCommonAncestorOfABinarySearchTree s = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode ans = s.lowestCommonAncestor(new TreeNode(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 }),
                new TreeNode(2), new TreeNode(8));
        assertEquals(6, ans.val);
    }

    @Test
    public void testCase2() {
        LowestCommonAncestorOfABinarySearchTree s = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode ans = s.lowestCommonAncestor(new TreeNode(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 }),
                new TreeNode(2), new TreeNode(4));
        assertEquals(2, ans.val);
    }

}
