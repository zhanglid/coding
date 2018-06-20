package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class FindPeakElementTest {

    @Test
    public void testCase() {
        FindPeakElement s = new FindPeakElement();
        int ans = s.findPeakElement(new int[] { 1, 2, 3, 1 });
        assertEquals(ans, 2);
    }

    @Test
    public void testCase2() {
        FindPeakElement s = new FindPeakElement();
        int ans = s.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 });
        assertEquals(ans == 1 || ans == 5, true);
    }

}
