package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class SumRootToLeafNumbersTest {

    @Test
    public void testCase() {
        SumRootToLeafNumbers s = new SumRootToLeafNumbers();
        int ans = s.sumNumbers(new TreeNode(new Integer[] { 4, 9, 0, 5, 1 }));
        assertEquals(ans, 1026);
    }
}
