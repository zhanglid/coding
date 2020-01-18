package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ShortestWordDistanceIIITest {

    @Test
    public void testCase() {
        ShortestWordDistanceIII s = new ShortestWordDistanceIII();
        int ans = s.shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" }, "makes",
                "coding");
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        ShortestWordDistanceIII s = new ShortestWordDistanceIII();
        int ans = s.shortestWordDistance(new String[] { "practice", "makes", "perfect", "coding", "makes" }, "makes",
                "makes");
        assertEquals(3, ans);
    }
}
