package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class SymmetricTreeTest {

    @Test
    public void testCase() {
        SymmetricTree s = new SymmetricTree();
        boolean ans = s.isSymmetric(new TreeNode(new Integer[] { 1, 2, 2, 3, 4, 4, 3 }));
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        SymmetricTree s = new SymmetricTree();
        boolean ans = s.isSymmetric(new TreeNode(new Integer[] { 1, 2, 2, null, 3, null, 3 }));
        assertEquals(false, ans);
    }
}
