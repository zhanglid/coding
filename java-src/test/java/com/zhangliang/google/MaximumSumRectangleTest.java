package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MaximumSumRectangleTest {

    @Test
    public void testCase() {
        MaximumSumRectangle s = new MaximumSumRectangle();
        int ans = s.solve(
                new int[][] { 
                    { 1, 2, -1, -4, -20 }, 
                    { -8, -3, 4, 2, 1 }, 
                    { 3, 8, 10, 1, 3 }, 
                    { -4, -1, 1, 7, -6 } 
                }
        );

        assertEquals(29, ans);
    }
}
