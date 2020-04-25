package com.zhangliang.leetcode;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ThreeSumClosestTest{

    @Test
    public void testCase() {
        ThreeSumClosest s = new ThreeSumClosest();
        int ans = s.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        assertEquals(ans, 2);
    }
}