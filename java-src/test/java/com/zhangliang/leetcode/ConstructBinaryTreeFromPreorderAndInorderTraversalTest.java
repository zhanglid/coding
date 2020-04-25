package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    @Test
    public void testCase() {
        ConstructBinaryTreeFromPreorderAndInorderTraversal s = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode ans = s.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
        assertEquals(ans.equals(new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 })), true);
    }
}
