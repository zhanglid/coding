package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RedundantConnectionTest {

    @Test
    public void testCase() {
        RedundantConnection s = new RedundantConnection();
        int[] ans = s.findRedundantConnection(new int[][] { { 1, 2 }, { 1, 3 }, { 2, 3 } });
        assertEquals("[2, 3]", Arrays.toString(ans));
    }

    @Test
    public void testCase2() {
        RedundantConnection s = new RedundantConnection();
        int[] ans = s.findRedundantConnection(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } });
        assertEquals("[1, 4]", Arrays.toString(ans));
    }
}
