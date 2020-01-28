package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class RecoverATreeFromPreorderTraversalTest {

    @Test
    public void testCase() {
        RecoverATreeFromPreorderTraversal s = new RecoverATreeFromPreorderTraversal();
        TreeNode ans = s.recoverFromPreorder("1-2--3--4-5--6--7");
        assertEquals(new TreeNode(new Integer[] { 1, 2, 5, 3, 4, 6, 7 }), ans);
    }

    @Test
    public void testCase2() {
        RecoverATreeFromPreorderTraversal s = new RecoverATreeFromPreorderTraversal();
        TreeNode ans = s.recoverFromPreorder("1-2--3---4-5--6---7");
        assertEquals(new TreeNode(new Integer[] { 1, 2, 5, 3, null, 6, null, 4, null, 7 }), ans);
    }

    @Test
    public void testCase3() {
        RecoverATreeFromPreorderTraversal s = new RecoverATreeFromPreorderTraversal();
        TreeNode ans = s.recoverFromPreorder("1-401--349---90--88");
        assertEquals(new TreeNode(new Integer[] { 1, 401, null, 349, 88, 90 }), ans);
    }
}
