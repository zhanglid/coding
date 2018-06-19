package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class ConvertSortedArrayToBinarySearchTreeTest {

    @Test
    public void testCase() {
        ConvertSortedArrayToBinarySearchTree s = new ConvertSortedArrayToBinarySearchTree();
        TreeNode ans = s.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
        TreeNode expected = new TreeNode(new Integer[] { 0, -3, 9, -10, null, 5 });
        assertEquals(expected.equals(ans), true);
    }
}
