package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class BinarySearchTreeIteratorTest {

    @Test
    public void testCase() {
        BinarySearchTreeIterator.BSTIterator s = new BinarySearchTreeIterator.BSTIterator(
                new TreeNode(new Integer[] { 2, 1, 3 }));
        assertEquals(true, s.hasNext());
        assertEquals(1, s.next());
        assertEquals(2, s.next());
        assertEquals(3, s.next());
        assertEquals(false, s.hasNext());
    }

    @Test
    public void errCase() {
        BinarySearchTreeIterator.BSTIterator s = new BinarySearchTreeIterator.BSTIterator(null);
        assertEquals(false, s.hasNext());
    }
}
