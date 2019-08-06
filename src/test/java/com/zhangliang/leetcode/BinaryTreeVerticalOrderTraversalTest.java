package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeVerticalOrderTraversalTest {

    private void assertCorrect(int[][] expected, List<List<Integer>> ans) {
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected[i].length; j++) {
                assertEquals(expected[i][j], (int) ans.get(i).get(j));
            }
        }
    }

    @Test
    public void testCase() {
        BinaryTreeVerticalOrderTraversal s = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> ans = s.verticalOrder(new TreeNode(new Integer[] { 3, 9, 20, null, null, 15, 7 }));
        assertCorrect(new int[][] { { 9 }, { 3, 15 }, { 20 }, { 7 } }, ans);
    }

    @Test
    public void testCase2() {
        BinaryTreeVerticalOrderTraversal s = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> ans = s.verticalOrder(new TreeNode(new Integer[] { 3, 9, 8, 4, 0, 1, 7 }));
        assertCorrect(new int[][] { { 4 }, { 9 }, { 3, 0, 1 }, { 8 }, { 7 } }, ans);
    }

    @Test
    public void testCase3() {
        BinaryTreeVerticalOrderTraversal s = new BinaryTreeVerticalOrderTraversal();
        List<List<Integer>> ans = s
                .verticalOrder(new TreeNode(new Integer[] { 3, 9, 8, 4, 0, 1, 7, null, null, null, 2, 5 }));
        assertCorrect(new int[][] { { 4 }, { 9, 5 }, { 3, 0, 1 }, { 8, 2 }, { 7 } }, ans);
    }
}
