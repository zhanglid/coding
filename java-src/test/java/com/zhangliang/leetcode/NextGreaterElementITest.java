package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class NextGreaterElementITest {

    @Test
    public void testCase() {
        NextGreaterElementI s = new NextGreaterElementI();
        int[] ans = s.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 });
        assertArrayEquals(new int[] { -1, 3, -1 }, ans);
    }

    @Test
    public void testCase2() {
        NextGreaterElementI s = new NextGreaterElementI();
        int[] ans = s.nextGreaterElement(new int[] { 2, 4 }, new int[] { 1, 2, 3, 4 });
        assertArrayEquals(new int[] { 3, -1 }, ans);
    }
}
