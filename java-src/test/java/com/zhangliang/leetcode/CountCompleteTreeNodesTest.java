package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class CountCompleteTreeNodesTest {

    @Test
    public void testCase() {
        CountCompleteTreeNodes s = new CountCompleteTreeNodes();
        int ans = s.countNodes(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, 6 }));
        assertEquals(6, ans);
    }
}
