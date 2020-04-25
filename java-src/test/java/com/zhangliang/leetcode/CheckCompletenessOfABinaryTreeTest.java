package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class CheckCompletenessOfABinaryTreeTest {

    @Test
    public void testCase() {
        CheckCompletenessOfABinaryTree s = new CheckCompletenessOfABinaryTree();
        boolean ans = s.isCompleteTree(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, 6 }));
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        CheckCompletenessOfABinaryTree s = new CheckCompletenessOfABinaryTree();
        boolean ans = s.isCompleteTree(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, null, 7 }));
        assertEquals(false, ans);
    }
}
