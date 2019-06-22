package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class SplitBstTest {

    @Test
    public void testCase() {
        SplitBst s = new SplitBst();
        TreeNode root = new TreeNode(new Integer[] { 4, 2, 6, 1, 3, 5, 7 });
        TreeNode[] ans = s.splitBST(root, 2);
        assertArrayEquals(ans, new TreeNode[] { new TreeNode(new Integer[] { 2, 1 }),
                new TreeNode(new Integer[] { 4, 3, 6, null, null, 5, 7 }) });
    }

    @Test
    public void errCase() {
        SplitBst s = new SplitBst();
        TreeNode root = new TreeNode(new Integer[] { 4, 2, 6, 1, 3, 5, 7 });
        TreeNode[] ans = s.splitBST(root, 0);
        assertArrayEquals(ans, new TreeNode[] { null, root });
    }

    @Test
    public void errCase2() {
        SplitBst s = new SplitBst();
        TreeNode root = null;
        TreeNode[] ans = s.splitBST(root, 0);
        assertArrayEquals(ans, new TreeNode[] { null, null });
    }
}
