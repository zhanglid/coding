package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AllOOneDataStructureTest {

    @Test
    public void testCase() {
        AllOOneDataStructure.AllOne s = new AllOOneDataStructure.AllOne();
        s.inc("a");
        s.inc("a");
        s.inc("a");
        s.inc("b");
        s.inc("b");
        assertEquals("a", s.getMaxKey());
        assertEquals("b", s.getMinKey());
        s.dec("a");
        s.dec("a");
        assertEquals("b", s.getMaxKey());
    }

    @Test
    public void errCase() {
        AllOOneDataStructure.AllOne s = new AllOOneDataStructure.AllOne();
        s.inc("a");
        s.inc("b");
        s.inc("b");
        s.inc("c");
        s.inc("c");
        s.inc("c");

        s.dec("b");
        s.dec("b");

        assertEquals("a", s.getMinKey());
        s.dec("a");
        assertEquals("c", s.getMaxKey());
        assertEquals("c", s.getMinKey());
    }

    // ["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
    // [[],["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]
    @Test
    public void errCase2() {
        AllOOneDataStructure.AllOne s = new AllOOneDataStructure.AllOne();
        s.inc("a");
        s.inc("b");
        s.inc("c");
        s.inc("d");
        s.inc("a");
        s.inc("b");
        s.inc("c");
        s.inc("d");
        s.inc("c");
        s.inc("d");
        s.inc("d");
        s.inc("a");

        assertEquals("b", s.getMinKey());
    }
}
