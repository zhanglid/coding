package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ShortestWordDistanceTest {

    @Test
    public void testCase() {
        ShortestWordDistance s = new ShortestWordDistance();
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        int ans = s.shortestDistance(words, "coding", "practice");
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        ShortestWordDistance s = new ShortestWordDistance();
        String[] words = { "practice", "makes", "perfect", "coding", "makes" };
        int ans = s.shortestDistance(words, "makes", "coding");
        assertEquals(1, ans);
    }
}
