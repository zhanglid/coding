package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TriangleTest {

    @Test
    public void testCase() {
        Triangle s = new Triangle();
        int ans = s.minimumTotal(Arrays.asList(Arrays.asList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)));
        assertEquals(11, ans);
    }
}
