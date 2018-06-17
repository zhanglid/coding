package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import com.zhangliang.Utils;
import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeLevelOrderTraversalTest {

    @Test
    public void testCase() {
        BinaryTreeLevelOrderTraversal s = new BinaryTreeLevelOrderTraversal();
        List<List<Integer>> ans = s.levelOrder(new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
        assertArrayEquals(new String[] { "[3]", "[9, 20]", "[15, 7]" }, Utils.getStrsFrom2DList(ans, false));
    }
}
