package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class DistinctSubsequencesTest {

    @Test
    public void testCase() {
        DistinctSubsequences s = new DistinctSubsequences();
        int ans = s.numDistinct("rabbbit", "rabbit");
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        DistinctSubsequences s = new DistinctSubsequences();
        int ans = s.numDistinct("babgbag", "bag");
        assertEquals(5, ans);
    }
}
