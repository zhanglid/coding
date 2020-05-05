package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BinarySearchTreeTest {

    @Test
    public void testCase() {
        BinarySearchTree s = new BinarySearchTree();
        s.insert(1);
        s.insert(5);
        s.insert(4);
        s.insert(3);
        s.insert(2);
        assertEquals(4, (int) s.ceiling(4));
        assertEquals(5, (int) s.ceiling(7));
        assertEquals(null, s.ceiling(0));
    }

    @Test
    public void testCase2() {
        BinarySearchTree s = new BinarySearchTree();
        s.insert(1);
        s.insert(5);
        s.insert(4);
        s.insert(3);
        s.insert(2);
        assertEquals(4, (int) s.floor(4));
        assertEquals(1, (int) s.floor(0));
        assertEquals(null, s.floor(6));
    }
}
