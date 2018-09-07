package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RangeSumQueryMutableTest {

    @Test
    public void testCase() {
        RangeSumQueryMutable s = new RangeSumQueryMutable(new int[] { 1, 3, 5 });
        assertEquals(9, s.sumRange(0, 2));
    }

    @Test
    public void testCase2() {
        RangeSumQueryMutable s = new RangeSumQueryMutable(new int[] { 1, 3, 5 });
        s.update(1, 2);
        assertEquals(8, s.sumRange(0, 2));
    }
}
