package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class SameTreeTest {

    @Test
    public void testCase() {
        SameTree s = new SameTree();
        boolean ans = s.isSameTree(new TreeNode(new Integer[] { 1, 2, 3 }), new TreeNode(new Integer[] { 1, 2, 3 }));
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        SameTree s = new SameTree();
        boolean ans = s.isSameTree(new TreeNode(new Integer[] { 1, 2, 1 }), new TreeNode(new Integer[] { 1, 1, 2 }));
        assertEquals(false, ans);
    }
}
