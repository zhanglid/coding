package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    @Test
    public void testCase() {
        ConstructBinaryTreeFromInorderAndPostorderTraversal s = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode ans = s.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
        TreeNode expected = new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        assertEquals(expected.equals(ans), true);
    }
}
