package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class ExclusiveTimeOfFunctionsTest {

    @Test
    public void testCase() {
        ExclusiveTimeOfFunctions s = new ExclusiveTimeOfFunctions();
        int[] ans = s.exclusiveTime(2, Arrays.asList("0:start:0", "1:start:2", "1:end:5", "0:end:6"));
        assertArrayEquals(new int[] { 3, 4 }, ans);
    }

    @Test
    public void errCase() {
        ExclusiveTimeOfFunctions s = new ExclusiveTimeOfFunctions();
        int[] ans = s.exclusiveTime(1,
                Arrays.asList("0:start:0", "0:start:2", "0:end:5", "0:start:6", "0:end:6", "0:end:7"));
        assertArrayEquals(new int[] { 8 }, ans);
    }
}
