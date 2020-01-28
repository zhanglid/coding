package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class ClosestLeafInABinaryTreeTest {

    @Test
    public void testCase() {
        ClosestLeafInABinaryTree s = new ClosestLeafInABinaryTree();
        int ans = s.findClosestLeaf(new TreeNode(new Integer[] { 1, 3, 2 }), 1);
        assertTrue(ans == 2 || ans == 3);
    }

    @Test
    public void testCase2() {
        ClosestLeafInABinaryTree s = new ClosestLeafInABinaryTree();
        int ans = s.findClosestLeaf(new TreeNode(new Integer[] { 1 }), 1);
        assertEquals(1, ans);
    }

    @Test
    public void testCase3() {
        ClosestLeafInABinaryTree s = new ClosestLeafInABinaryTree();
        int ans = s.findClosestLeaf(new TreeNode(new Integer[] { 1, 2, 3, 4, null, null, null, 5, null, 6 }), 2);
        assertEquals(3, ans);
    }

    @Test
    public void errCase() {
        ClosestLeafInABinaryTree s = new ClosestLeafInABinaryTree();
        int ans = s.findClosestLeaf(
                new TreeNode(new Integer[] { 1, 2, 3, null, null, 4, 5, 6, null, null, 7, 8, 9, 10 }), 4);
        assertTrue(8 == ans || 9 == ans);
    }

    @Test
    public void errCase2() {
        ClosestLeafInABinaryTree s = new ClosestLeafInABinaryTree();
        int ans = s.findClosestLeaf(
                new TreeNode(new Integer[] { 1, 2, 3, null, null, 4, 5, 6, null, null, 7, 8, 9, 10 }), 2);
        assertTrue(2 == ans);
    }
}
