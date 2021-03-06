package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class NextPermutationTest {
    @Test
    public void testCase() {
        NextPermutation s = new NextPermutation();
        int[] ans = new int[] { 1, 2, 3 };
        s.nextPermutation(ans);
        assertArrayEquals(ans, new int[] { 1, 3, 2 });
    }

    @Test
    public void errCase() {
        NextPermutation s = new NextPermutation();
        int[] ans = new int[] { 1, 3, 2 };
        s.nextPermutation(ans);
        assertArrayEquals(ans, new int[] { 2, 1, 3 });
    }

    @Test
    public void errCase2() {
        NextPermutation s = new NextPermutation();
        int[] ans = new int[] { 2, 1, 3 };
        s.nextPermutation(ans);
        assertArrayEquals(ans, new int[] { 2, 3, 1 });
    }

    @Test
    public void errCase3() {
        NextPermutation s = new NextPermutation();
        int[] ans = new int[] { 2, 3, 1 };
        s.nextPermutation(ans);
        assertArrayEquals(ans, new int[] { 3, 1, 2 });
    }

    @Test
    public void errCase4() {
        NextPermutation s = new NextPermutation();
        int[] ans = new int[] { 1, 1 };
        s.nextPermutation(ans);
        assertArrayEquals(ans, new int[] { 1, 1 });
    }
}