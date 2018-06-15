package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import com.zhangliang.utils.TreeNode;
import com.zhangliang.Utils;
import org.junit.Test;

public class UniqueBinarySearchTreesIITest {

    @Test
    public void testCase() {
        UniqueBinarySearchTreesII s = new UniqueBinarySearchTreesII();
        List<TreeNode> ans = s.generateTrees(3);
        String[] expected = new String[] { "[1, null, 3, 2]", "[3, 2, null, 1]", "[3, 1, null, null, 2]", "[2, 1, 3]",
                "[1, null, 2, null, 3]" };
        Arrays.sort(expected);
        assertArrayEquals(expected, Utils.getStrsFromList(ans));
    }
}
