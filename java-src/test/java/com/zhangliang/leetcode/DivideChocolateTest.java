package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class DivideChocolateTest {

    @Test
    public void testCase() {
        DivideChocolate s = new DivideChocolate();
        int ans = s.maximizeSweetness(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5);
        assertEquals(6, ans);
    }

    @Test
    public void testCase2() {
        DivideChocolate s = new DivideChocolate();
        int ans = s.maximizeSweetness(new int[] { 5, 6, 7, 8, 9, 1, 2, 3, 4 }, 8);
        assertEquals(1, ans);
    }

    @Test
    public void testCase3() {
        DivideChocolate s = new DivideChocolate();
        int ans = s.maximizeSweetness(new int[] { 1, 2, 2, 1, 2, 2, 1, 2, 2 }, 2);
        assertEquals(5, ans);
    }
}
