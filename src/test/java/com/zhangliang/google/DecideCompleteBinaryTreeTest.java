package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class DecideCompleteBinaryTreeTest {

    @Test
    public void testCase() {
        DecideCompleteBinaryTree s = new DecideCompleteBinaryTree();
        TreeNode tree = new TreeNode(new Integer[] { 2, 1, 3 });
        boolean ans = s.isComplete(tree);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        DecideCompleteBinaryTree s = new DecideCompleteBinaryTree();
        TreeNode tree = new TreeNode(new Integer[] { 3, 2, 4, 1, null });
        boolean ans = s.isComplete(tree);
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        DecideCompleteBinaryTree s = new DecideCompleteBinaryTree();
        TreeNode tree = new TreeNode(new Integer[] { 4, 2, 5, null, 3 });
        boolean ans = s.isComplete(tree);
        assertEquals(false, ans);
    }
}
