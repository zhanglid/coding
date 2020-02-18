package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class ExamRoomTest {

    @Test
    public void testCase() {
        ExamRoom s = new ExamRoom(8);
        assertEquals(0, s.seat());
        assertEquals(7, s.seat());
        assertEquals(3, s.seat());
        s.leave(0);
        s.leave(7);
        assertEquals(7, s.seat());
        assertEquals(0, s.seat());
        assertEquals(5, s.seat());
        assertEquals(1, s.seat());
        assertEquals(2, s.seat());
    }
}
