package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class ConvertSortedListToBinarySearchTreeTest {
    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.right), getDepth(root.left)) + 1;
    }

    private int[] validBinaryTree(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        }
        int[] left = validBinaryTree(root.left);
        int[] right = validBinaryTree(root.right);
        if (left == null || right == null) {
            return null;
        }
        if (left[1] > root.val) {
            return null;
        }

        if (right[0] < root.val) {
            return null;
        }

        return new int[] { Math.min(root.val, left[0]), Math.max(root.val, right[1]) };
    }

    private List<Integer> getAllValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ans.addAll(getAllValues(root.left));
        ans.add(root.val);
        ans.addAll(getAllValues(root.right));
        return ans;
    }

    private void assertCorrect(int[] values, TreeNode ans) {
        if (values.length < 1) {
            assertEquals(null, ans);
            return;
        }
        assertTrue(Math.abs(getDepth(ans.right) - getDepth(ans.left)) <= 1);
        assertNotNull(validBinaryTree(ans));
        List<Integer> valueList = getAllValues(ans);
        assertEquals(values.length, valueList.size());
        Collections.sort(valueList);
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], (int) valueList.get(i));
        }
    }

    @Test
    public void testCase() {
        ConvertSortedListToBinarySearchTree s = new ConvertSortedListToBinarySearchTree();
        int[] values = { -10, -3, 0, 5, 9 };
        TreeNode ans = s.sortedListToBST(new ListNode(values));
        assertCorrect(values, ans);
    }
}
