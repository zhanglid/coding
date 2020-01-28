package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FindTheCelebrityTest {

    @Test
    public void testCase() {
        FindTheCelebrity.Solution s = new FindTheCelebrity.Solution(
                new int[][] { { 1, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 } });
        int ans = s.findCelebrity(3);
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        FindTheCelebrity.Solution s = new FindTheCelebrity.Solution(
                new int[][] { { 1, 0, 1 }, { 1, 1, 0 }, { 0, 1, 1 } });
        int ans = s.findCelebrity(3);
        assertEquals(-1, ans);
    }

    @Test
    public void errCase() {
        FindTheCelebrity.Solution s = new FindTheCelebrity.Solution(new int[][] { { 1, 1 }, { 1, 1 } });
        int ans = s.findCelebrity(2);
        assertEquals(-1, ans);
    }

    @Test
    public void errCase2() {
        FindTheCelebrity.Solution s = new FindTheCelebrity.Solution(new int[][] { { 1, 0 }, { 0, 1 } });
        int ans = s.findCelebrity(2);
        assertEquals(-1, ans);
    }
}
