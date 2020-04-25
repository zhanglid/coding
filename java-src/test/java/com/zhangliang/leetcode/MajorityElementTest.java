package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void testCase() {
        MajorityElement s = new MajorityElement();
        int ans = s.majorityElement(new int[] { 3, 2, 3 });
        assertEquals(ans, 3);
    }

    @Test
    public void testCase2() {
        MajorityElement s = new MajorityElement();
        int ans = s.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 });
        assertEquals(ans, 2);
    }

}
