package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class HouseRobberIIITest {

    @Test
    public void testCase() {
        HouseRobberIII s = new HouseRobberIII();
        int ans = s.rob(new TreeNode(new Integer[] { 3, 2, 3, null, 3, null, 1 }));
        assertEquals(7, ans);
    }

    @Test
    public void testCase2() {
        HouseRobberIII s = new HouseRobberIII();
        int ans = s.rob(new TreeNode(new Integer[] { 3, 4, 5, 1, 3, null, 1 }));
        assertEquals(9, ans);
    }
}
