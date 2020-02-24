package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class MyCalendarTwoTest {

    @Test
    public void testCase() {
        MyCalendarTwo s = new MyCalendarTwo();
        assertEquals(true, s.book(10, 20));
        assertEquals(true, s.book(50, 60));
        assertEquals(true, s.book(10, 40));
        assertEquals(false, s.book(5, 15));
        assertEquals(true, s.book(5, 10));
        assertEquals(true, s.book(25, 55));
    }
}
