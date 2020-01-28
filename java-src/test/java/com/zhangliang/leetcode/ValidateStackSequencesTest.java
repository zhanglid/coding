package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidateStackSequencesTest {

    @Test
    public void testCase() {
        ValidateStackSequences s = new ValidateStackSequences();
        boolean ans = s.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 5, 3, 2, 1 });
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidateStackSequences s = new ValidateStackSequences();
        boolean ans = s.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 3, 5, 1, 2 });
        assertEquals(false, ans);
    }
}
