package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GasStationTest {

    @Test
    public void testCase() {
        GasStation s = new GasStation();
        int ans = s.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 });
        assertEquals(3, ans);
    }

    @Test
    public void errCase() {
        GasStation s = new GasStation();
        int ans = s.canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 });
        assertEquals(-1, ans);
    }
}
