package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void testCase() {
        ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
        int[] ans = s.productExceptSelf(new int[] { 1, 2, 3, 4 });
        assertArrayEquals(new int[] { 24, 12, 8, 6 }, ans);
    }
}
