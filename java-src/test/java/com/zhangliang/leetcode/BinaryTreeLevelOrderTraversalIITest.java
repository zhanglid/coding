package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import com.zhangliang.Utils;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeLevelOrderTraversalIITest {

    @Test
    public void testCase() {
        BinaryTreeLevelOrderTraversalII s = new BinaryTreeLevelOrderTraversalII();
        TreeNode input = new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 });
        List<List<Integer>> ans = s.levelOrderBottom(input);
        assertArrayEquals(new String[] { "[15, 7]", "[9, 20]", "[3]" }, Utils.getStrsFrom2DList(ans, false));
    }
}
