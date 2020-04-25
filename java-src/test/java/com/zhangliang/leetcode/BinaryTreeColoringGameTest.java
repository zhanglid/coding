package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeColoringGameTest {

    @Test
    public void testCase() {
        BinaryTreeColoringGame s = new BinaryTreeColoringGame();
        boolean ans = s.btreeGameWinningMove(new TreeNode(new Integer[] { 1, 2, 3, 4, 5 }), 5, 4);
        assertEquals(true, ans);
    }
}
