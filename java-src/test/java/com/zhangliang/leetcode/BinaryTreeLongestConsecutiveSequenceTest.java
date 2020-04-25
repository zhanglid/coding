package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinaryTreeLongestConsecutiveSequenceTest {

    @Test
    public void testCase() {
        BinaryTreeLongestConsecutiveSequence s = new BinaryTreeLongestConsecutiveSequence();
        int ans = s.longestConsecutive(new TreeNode(new Integer[] { 1, null, 3, 2, 4, null, null, null, 5 }));
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        BinaryTreeLongestConsecutiveSequence s = new BinaryTreeLongestConsecutiveSequence();
        int ans = s.longestConsecutive(new TreeNode(new Integer[] { 2, null, 3, 2, null, 1 }));
        assertEquals(2, ans);
    }
}
