package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class AllNodesDistanceKInBinaryTreeTest {
    private void assertCorrect(int[] expected, List<Integer> result) {
        Arrays.sort(expected);
        Collections.sort(result);
        assertEquals(Arrays.toString(expected), result.toString());
    }

    @Test
    public void testCase() {
        AllNodesDistanceKInBinaryTree s = new AllNodesDistanceKInBinaryTree();
        TreeNode root = new TreeNode(new Integer[] { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 });
        TreeNode target = root.left;
        List<Integer> ans = s.distanceK(root, target, 2);
        assertCorrect(new int[] { 7, 4, 1 }, ans);
    }

    @Test
    public void testCase2() {
        AllNodesDistanceKInBinaryTree s = new AllNodesDistanceKInBinaryTree();
        TreeNode root = new TreeNode(new Integer[] { 0, null, 1, null, 2, null, 3 });
        TreeNode target = root.right;
        List<Integer> ans = s.distanceK(root, target, 2);
        assertCorrect(new int[] { 3 }, ans);
    }

    @Test
    public void testCase3() {
        AllNodesDistanceKInBinaryTree s = new AllNodesDistanceKInBinaryTree();
        TreeNode root = new TreeNode(new Integer[] { 0, null, 1, null, 2, null, 3, 4 });
        TreeNode target = root.right.right;
        List<Integer> ans = s.distanceK(root, target, 2);
        assertCorrect(new int[] { 0, 4 }, ans);
    }
}
