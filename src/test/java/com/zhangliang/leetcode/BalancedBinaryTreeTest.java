package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BalancedBinaryTreeTest {

    @Test
    public void testCase() {
        BalancedBinaryTree s = new BalancedBinaryTree();
        TreeNode input = new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        boolean ans = s.isBalanced(input);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        BalancedBinaryTree s = new BalancedBinaryTree();
        TreeNode input = new TreeNode(new Integer[] { 1, 2, 2, 3, 3, null, null, 4, 4 });
        boolean ans = s.isBalanced(input);
        assertEquals(false, ans);
    }
}
