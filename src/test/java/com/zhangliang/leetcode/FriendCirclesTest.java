package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FriendCirclesTest {

    @Test
    public void testCase() {
        FriendCircles s = new FriendCircles();
        int ans = s.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } });
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        FriendCircles s = new FriendCircles();
        int ans = s.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } });
        assertEquals(1, ans);
    }
}
