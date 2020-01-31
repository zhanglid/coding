package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SetMismatchTest {

    @Test
    public void testCase() {
        SetMismatch s = new SetMismatch();
        int[] ans = s.findErrorNums(new int[] { 1, 2, 2, 4 });
        assertArrayEquals(new int[] { 2, 3 }, ans);
    }
}
