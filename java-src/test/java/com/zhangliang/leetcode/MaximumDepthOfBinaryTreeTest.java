package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class MaximumDepthOfBinaryTreeTest {

    @Test
    public void testCase() {
        MaximumDepthOfBinaryTree s = new MaximumDepthOfBinaryTree();
        int ans = s.maxDepth(new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
        assertEquals(3, ans);
    }
}
