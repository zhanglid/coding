package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class VerticalOrderTraversalOfABinaryTreeTest {
    private int[][] toArray(List<List<Integer>> nums) {
        int[][] ans = new int[nums.size()][];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = new int[nums.get(i).size()];
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = nums.get(i).get(j);
            }
        }
        return ans;
    }

    private void assertCorrect(int[][] expected, List<List<Integer>> ans) {
        assertArrayEquals(expected, toArray(ans));
    }

    @Test
    public void testCase() {
        VerticalOrderTraversalOfABinaryTree s = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> ans = s.verticalTraversal(new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
        assertCorrect(new int[][] { { 9 }, { 3, 15 }, { 20 }, { 7 } }, ans);
    }

    @Test
    public void testCase2() {
        VerticalOrderTraversalOfABinaryTree s = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> ans = s.verticalTraversal(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }));
        assertCorrect(new int[][] { { 4 }, { 2 }, { 1, 5, 6 }, { 3 }, { 7 } }, ans);
    }

    @Test
    public void errCase() {
        VerticalOrderTraversalOfABinaryTree s = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> ans = s.verticalTraversal(
                new TreeNode(new Integer[] { 0, 8, 1, null, null, 3, 2, null, 4, 5, null, null, 7, 6 }));
        assertCorrect(new int[][] { { 8 }, { 0, 3, 6 }, { 1, 4, 5 }, { 2, 7 } }, ans);
    }

    @Test
    public void errCase2() {
        VerticalOrderTraversalOfABinaryTree s = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> ans = s.verticalTraversal(
                new TreeNode(new Integer[] { 0, 2, 1, 3, null, null, null, 4, 5, null, 7, 6, null, 10, 8, 11, 9 }));
        assertCorrect(new int[][] { { 4, 10, 11 }, { 3, 6, 7 }, { 2, 5, 8, 9 }, { 0 }, { 1 } }, ans);
    }

    @Test
    public void testCase3() {
        VerticalOrderTraversalOfABinaryTree s = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> ans = s.verticalTraversal(new TreeNode(
                new Integer[] { 0, 5, 1, 9, null, 2, null, null, null, null, 3, 4, 8, 6, null, null, null, 7 }));
        assertCorrect(new int[][] { { 9, 7 }, { 5, 6 }, { 0, 2, 4 }, { 1, 3 }, { 8 } }, ans);
    }

    @Test
    public void testCase4() {
        VerticalOrderTraversalOfABinaryTree s = new VerticalOrderTraversalOfABinaryTree();
        List<List<Integer>> ans = s.verticalTraversal(new TreeNode(new Integer[] { 0, 1, 2, 4, 5, 9, 3, 11, null, null,
                10, 15, null, 6, 18, 14, null, null, 21, null, null, 7, 12, null, null, 22, null, null, 24, 13, 8, null,
                17, null, null, null, null, null, null, 16, 19, null, null, null, null, 23, 20 }));
        assertCorrect(new int[][] { { 22 }, { 14 }, { 11 }, { 4 }, { 1, 15, 13 }, { 0, 5, 9, 7, 16 },
                { 2, 6, 10, 8, 23 }, { 3, 12, 21, 19 }, { 18, 17, 24, 20 } }, ans);
    }
}
