package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import com.zhangliang.utils.TreeNode;
import com.zhangliang.Utils;

import org.junit.Test;

public class BinaryTreeZigzagLevelOrderTraversalTest {

    @Test
    public void testCase() {
        BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> ans = s.zigzagLevelOrder(new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
        assertArrayEquals(new String[] { "[3]", "[20, 9]", "[15, 7]" }, Utils.getStrsFrom2DList(ans, false));
    }

    @Test
    public void errCase() {
        BinaryTreeZigzagLevelOrderTraversal s = new BinaryTreeZigzagLevelOrderTraversal();
        List<List<Integer>> ans = s.zigzagLevelOrder(null);
        assertArrayEquals(new String[] {}, Utils.getStrsFrom2DList(ans, false));
    }
}
