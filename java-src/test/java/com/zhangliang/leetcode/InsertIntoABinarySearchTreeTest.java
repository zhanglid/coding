package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class InsertIntoABinarySearchTreeTest {

    @Test
    public void testCase() {
        InsertIntoABinarySearchTree s = new InsertIntoABinarySearchTree();
        TreeNode ans = s.insertIntoBST(new TreeNode(new Integer[] { 4, 2, 7, 1, 3 }), 5);
        assertEquals(true, ans.equals(new TreeNode(new Integer[] { 4, 2, 7, 1, 3, 5 }))
                || ans.equals(new TreeNode(new Integer[] { 5, 2, 7, 1, 3, null, null, null, null, null, 4 })));
    }
}
