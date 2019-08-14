package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class ConstructBinarySearchTreeFromPreorderTraversalTest {

    @Test
    public void testCase() {
        ConstructBinarySearchTreeFromPreorderTraversal s = new ConstructBinarySearchTreeFromPreorderTraversal();
        TreeNode ans = s.bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
        assertEquals(new TreeNode(new Integer[] { 8, 5, 10, 1, 7, null, 12 }), ans);
    }
}
