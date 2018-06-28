package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreePreorderTraversalTest {

    @Test
    public void testCase() {
        BinaryTreePreorderTraversal s = new BinaryTreePreorderTraversal();
        List<Integer> ans = s.preorderTraversal(new TreeNode(new Integer[] { 1, null, 2, 3 }));
        assertEquals("[1, 2, 3]", ans.toString());
    }
}
