package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class CapacityToShipPackagesWithinDDaysTest {

    @Test
    public void testCase() {
        CapacityToShipPackagesWithinDDays s = new CapacityToShipPackagesWithinDDays();
        int ans = s.shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5);
        assertEquals(15, ans);
    }

    @Test
    public void testCase2() {
        CapacityToShipPackagesWithinDDays s = new CapacityToShipPackagesWithinDDays();
        int ans = s.shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3);
        assertEquals(6, ans);
    }

    @Test
    public void testCase3() {
        CapacityToShipPackagesWithinDDays s = new CapacityToShipPackagesWithinDDays();
        int ans = s.shipWithinDays(new int[] { 1, 2, 3, 1, 1 }, 4);
        assertEquals(3, ans);
    }
}
