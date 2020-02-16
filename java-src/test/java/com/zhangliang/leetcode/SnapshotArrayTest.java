package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class SnapshotArrayTest {

    @Test
    public void testCase() {
        SnapshotArray s = new SnapshotArray(3);
        s.set(0, 5);
        assertEquals(0, s.snap());
        s.set(0, 6);
        assertEquals(s.get(0, 0), 5);
    }

    @Test
    public void errCase() {
        SnapshotArray s = new SnapshotArray(1);
        s.set(0, 15);
        assertEquals(0, s.snap());
        assertEquals(1, s.snap());
        assertEquals(2, s.snap());
        assertEquals(s.get(0, 2), 15);
        assertEquals(3, s.snap());
        assertEquals(4, s.snap());
        assertEquals(s.get(0, 0), 15);
    }
}
