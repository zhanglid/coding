package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ShortestWayToFormStringTest {

    @Test
    public void testCase() {
        ShortestWayToFormString s = new ShortestWayToFormString();
        int ans = s.shortestWay("abc", "abcbc");
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        ShortestWayToFormString s = new ShortestWayToFormString();
        int ans = s.shortestWay("abc", "acdbc");
        assertEquals(-1, ans);
    }

    @Test
    public void testCase3() {
        ShortestWayToFormString s = new ShortestWayToFormString();
        int ans = s.shortestWay("xyz", "xzyxz");
        assertEquals(3, ans);
    }
}
