package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeInorderTraversalTest {

    @Test
    public void testCase() {
        BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
        List<Integer> ans = s.inorderTraversal(new TreeNode(new Integer[] { 1, null, 2, 3 }));
        assertEquals("[1, 3, 2]", ans.toString());
    }
}
