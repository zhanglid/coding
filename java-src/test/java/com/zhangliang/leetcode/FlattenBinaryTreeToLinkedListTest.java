package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class FlattenBinaryTreeToLinkedListTest {

    @Test
    public void testCase() {
        FlattenBinaryTreeToLinkedList s = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(new Integer[] { 1, 2, 5, 3, 4, null, 6 });
        s.flatten(root);
        TreeNode expected = new TreeNode(new Integer[] { 1, null, 2, null, 3, null, 4, null, 5, null, 6 });
        assertEquals(expected.equals(root), true);
    }
}
