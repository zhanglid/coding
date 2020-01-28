package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class ConstructBinaryTreeFromStringTest {

    @Test
    public void testCase() {
        ConstructBinaryTreeFromString s = new ConstructBinaryTreeFromString();
        TreeNode ans = s.str2tree("4(2(3)(1))(6(5))");
        assertEquals(new TreeNode(new Integer[] { 4, 2, 6, 3, 1, 5 }), ans);
    }
    /**
     *              -4
     *             /  \
     *            2    6
     *           / \  / \
     *          3  1  5  7
     */      
    @Test
    public void errCase() {
        ConstructBinaryTreeFromString s = new ConstructBinaryTreeFromString();
        TreeNode ans = s.str2tree("-4(2(3)(1))(6(5)(7))");
        assertEquals(new TreeNode(new Integer[] { -4, 2, 6, 3, 1, 5, 7 }), ans);
    }
}
