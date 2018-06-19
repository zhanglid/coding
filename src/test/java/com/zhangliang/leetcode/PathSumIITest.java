package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import com.zhangliang.utils.TreeNode;
import com.zhangliang.Utils;

import org.junit.Test;

public class PathSumIITest {

    @Test
    public void testCase() {
        PathSumII s = new PathSumII();
        TreeNode root = new TreeNode(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 });
        List<List<Integer>> ans = s.pathSum(root, 22);
        assertArrayEquals(new String[] { "[5, 4, 11, 2]", "[5, 8, 4, 5]" }, Utils.getStrsFrom2DList(ans));
    }
}
