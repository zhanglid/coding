package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class FindAnagramMappingsTest {

    @Test
    public void testCase() {
        FindAnagramMappings s = new FindAnagramMappings();
        int[] ans = s.anagramMappings(new int[] { 12, 28, 46, 32, 50 }, new int[] { 50, 12, 32, 46, 28 });
        assertArrayEquals(new int[] { 1, 4, 3, 2, 0 }, ans);
    }
}
