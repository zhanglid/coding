package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class CountOfSmallerNumbersAfterSelfTest {

    @Test
    public void testCase() {
        CountOfSmallerNumbersAfterSelf s = new CountOfSmallerNumbersAfterSelf();
        List<Integer> ans = s.countSmaller(new int[] { 5, 2, 6, 1 });
        assertArrayEquals(Arrays.asList(2, 1, 1, 0).toArray(new Integer[0]), ans.toArray(new Integer[0]));
    }
}
