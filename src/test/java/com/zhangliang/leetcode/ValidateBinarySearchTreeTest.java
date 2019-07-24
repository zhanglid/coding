package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class ValidateBinarySearchTreeTest {

    @Test
    public void testCase() {
        ValidateBinarySearchTree s = new ValidateBinarySearchTree();
        boolean ans = s.isValidBST(new TreeNode(new Integer[] { 2, 1, 3 }));
        assertEquals(true, ans);
    }

    @Test
    public void errCase() {
        ValidateBinarySearchTree s = new ValidateBinarySearchTree();
        boolean ans = s.isValidBST(new TreeNode(new Integer[] { 2147483647 }));
        assertEquals(true, ans);
    }

    @Test
    public void errCase2() {
        ValidateBinarySearchTree s = new ValidateBinarySearchTree();
        boolean ans = s.isValidBST(null);
        assertEquals(true, ans);
    }

    @Test
    public void errCase3() {
        ValidateBinarySearchTree s = new ValidateBinarySearchTree();
        boolean ans = s.isValidBST(new TreeNode(new Integer[] { 1, 1 }));
        assertEquals(false, ans);
    }
}
