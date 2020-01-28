package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeRightSideViewTest {

    @Test
    public void testCase() {
        BinaryTreeRightSideView s = new BinaryTreeRightSideView();
        TreeNode node = new TreeNode(new Integer[] { 1, 2, 3, null, 5, null, 4 });
        List<Integer> ans = s.rightSideView(node);
        assertEquals(Arrays.asList(1, 3, 4), ans);
    }

    @Test
    public void testCase2() {
        BinaryTreeRightSideView s = new BinaryTreeRightSideView();
        TreeNode node = new TreeNode(new Integer[] { 1, 2, 3, 4 });
        List<Integer> ans = s.rightSideView(node);
        assertEquals(Arrays.asList(1, 3, 4), ans);
    }
}
