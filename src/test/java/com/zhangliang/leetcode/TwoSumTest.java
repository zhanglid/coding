package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TwoSumTest{

    @Test
    public void testDefault() {
		TwoSum s = new TwoSum();
		String ans = Arrays.toString(s.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        assertEquals(ans, "[0, 1]");
    }

}
