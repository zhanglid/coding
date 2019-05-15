package com.zhangliang.leetcode;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class MaximumAverageSubarrayITest {

    @Test
    public void testCase() {
        MaximumAverageSubarrayI s = new MaximumAverageSubarrayI();
        double ans = s.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4);
        assertEquals(12.75, ans, Double.MIN_NORMAL);
    }
}
