package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class DiameterOfBinaryTreeTest {

    @Test
    public void testCase() {
        DiameterOfBinaryTree s = new DiameterOfBinaryTree();
        int ans = s.diameterOfBinaryTree(new TreeNode(new Integer[] { 1, 2, 3, 4, 5 }));
        assertEquals(3, ans);
    }
}
