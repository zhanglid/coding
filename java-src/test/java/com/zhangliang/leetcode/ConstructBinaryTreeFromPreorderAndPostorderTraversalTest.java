package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversalTest {

    @Test
    public void testCase() {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal s = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        int[] pre = new int[] { 1, 2, 4, 5, 3, 6, 7 };
        int[] post = new int[] { 4, 5, 2, 6, 7, 3, 1 };
        TreeNode ans = s.constructFromPrePost(pre, post);
        assertEquals("[1, 2, 3, 4, 5, 6, 7]", ans.toString());
    }
}
