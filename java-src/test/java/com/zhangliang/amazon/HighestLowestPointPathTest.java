package com.zhangliang.amazon;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HighestLowestPointPathTest {

    @Test
    public void testCase() {
        int ans = HighestLowestPointPath.solve(new int[][] { { 5, 4, 5 }, { 1, 3, 6 } });
        assertEquals(4, ans);
    }
}
