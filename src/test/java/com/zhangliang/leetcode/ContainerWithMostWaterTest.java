package com.zhangliang.leetcode;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ContainerWithMostWaterTest{

    @Test
    public void testCase() {
        ContainerWithMostWater s = new ContainerWithMostWater();
        int ans = s.maxArea(new int[]{1, 1});
        assertEquals(ans, 1);
    }
}