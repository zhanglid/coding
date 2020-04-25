package com.zhangliang.lintcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CountOfSmallerNumberBeforeItselfTest {

    @Test
    public void testCase() {
        CountOfSmallerNumberBeforeItself s = new CountOfSmallerNumberBeforeItself();
        List<Integer> ans = s.countOfSmallerNumberII(new int[] { 1, 2, 7, 8, 5 });
        assertEquals(Arrays.asList(0, 1, 2, 3, 2), ans);
    }

    @Test
    public void errCase() {
        CountOfSmallerNumberBeforeItself s = new CountOfSmallerNumberBeforeItself();
        List<Integer> ans = s.countOfSmallerNumberII(new int[] { 68, 64, 53, 43, 38, 3 });
        assertEquals(Arrays.asList(0, 0, 0, 0, 0, 0), ans);
    }
}
