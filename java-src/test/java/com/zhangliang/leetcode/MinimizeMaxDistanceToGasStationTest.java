package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MinimizeMaxDistanceToGasStationTest {
    double DELTA = 0.000001;

    @Test
    public void testCase() {
        MinimizeMaxDistanceToGasStation s = new MinimizeMaxDistanceToGasStation();
        double ans = s.minmaxGasDist(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 9);
        assertEquals(0.500000, ans, this.DELTA);
    }

    @Test
    public void testCase2() {
        MinimizeMaxDistanceToGasStation s = new MinimizeMaxDistanceToGasStation();
        double ans = s.minmaxGasDist(new int[] { 10, 19, 25, 27, 56, 63, 70, 87, 96, 97 }, 3);
        assertEquals(9.666666666666666, ans, this.DELTA);
    }

    @Test
    public void errCase() {
        MinimizeMaxDistanceToGasStation s = new MinimizeMaxDistanceToGasStation();
        double ans = s.minmaxGasDist(new int[] { 5, 15, 21, 45, 51, 56, 57, 73, 88, 95 }, 5);
        assertEquals(8, ans, this.DELTA);
    }
}
