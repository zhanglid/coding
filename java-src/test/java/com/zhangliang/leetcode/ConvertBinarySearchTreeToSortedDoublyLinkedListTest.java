package com.zhangliang.leetcode;

import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class ConvertBinarySearchTreeToSortedDoublyLinkedListTest {

    private void assertCorrect(int[] expected, TreeNode ans) {
        Arrays.sort(expected);
        TreeNode cur = ans;
        for (int i = 0; i < expected.length; i++) {
            assertTrue(cur.val + " not equal to " + expected[i], cur.val == expected[i]);
            assertTrue(cur.right.val + " left is not connect to " + cur.val, cur.right.left == cur);
            cur = cur.right;
        }
        if (expected.length > 0) {
            assertTrue(cur.val == expected[0]);
        }
    }

    @Test
    public void testCase() {
        ConvertBinarySearchTreeToSortedDoublyLinkedList s = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
        TreeNode ans = s.treeToDoublyList(new TreeNode(new Integer[] { 4, 2, 5, 1, 3 }));
        assertCorrect(new int[] { 4, 2, 5, 1, 3 }, ans);
    }
}
