package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class SecondMinimumNodeInABinaryTreeTest {

    @Test
    public void testCase() {
        SecondMinimumNodeInABinaryTree s = new SecondMinimumNodeInABinaryTree();
        int ans = s.findSecondMinimumValue(new TreeNode(new Integer[] { 2, 2, 5, null, null, 5, 7 }));
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        SecondMinimumNodeInABinaryTree s = new SecondMinimumNodeInABinaryTree();
        int ans = s.findSecondMinimumValue(new TreeNode(new Integer[] { 2, 2, 2 }));
        assertEquals(-1, ans);
    }
}
