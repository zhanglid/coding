package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class ClosestBinarySearchTreeValueTest {

    @Test
    public void testCase() {
        ClosestBinarySearchTreeValue s = new ClosestBinarySearchTreeValue();
        int ans = s.closestValue(new TreeNode(new Integer[] { 4, 2, 5, 1, 3 }), 3.714286);
        assertEquals(4, ans);
    }
}
