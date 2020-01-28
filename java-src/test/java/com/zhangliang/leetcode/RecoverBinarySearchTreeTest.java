package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class RecoverBinarySearchTreeTest {

    @Test
    public void testCase() {
        RecoverBinarySearchTree s = new RecoverBinarySearchTree();
        TreeNode input = new TreeNode(new Integer[] { 1, 3, null, null, 2 });
        s.recoverTree(input);
        assertEquals(input.equals(new TreeNode(new Integer[] { 3, 1, null, null, 2 })), true);
    }

    @Test
    public void testCase2() {
        RecoverBinarySearchTree s = new RecoverBinarySearchTree();
        TreeNode input = new TreeNode(new Integer[] { 3, 1, 4, null, null, 2 });
        s.recoverTree(input);
        assertEquals(input.equals(new TreeNode(new Integer[] { 2, 1, 4, null, null, 3 })), true);
    }

    @Test
    public void errCase() {
        RecoverBinarySearchTree s = new RecoverBinarySearchTree();
        TreeNode input = new TreeNode(new Integer[] { 2, 3, 1 });
        s.recoverTree(input);
        assertEquals(input.equals(new TreeNode(new Integer[] { 2, 1, 3 })), true);
    }
}
