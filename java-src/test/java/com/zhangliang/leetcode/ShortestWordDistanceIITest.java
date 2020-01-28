package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ShortestWordDistanceIITest {

    @Test
    public void testCase() {
        ShortestWordDistanceII.WordDistance s = new ShortestWordDistanceII.WordDistance(
                new String[] { "practice", "makes", "perfect", "coding", "makes" });
        assertEquals(3, s.shortest("coding", "practice"));
        assertEquals(1, s.shortest("makes", "coding"));
    }
}
