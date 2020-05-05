package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class QuickSelectTopKTest {

    @Test
    public void testCase() {
        QuickSelectTopK s = new QuickSelectTopK();
        int ans = s.quickTopKth(new int[] { 4, 6, 3, 1, 5, 2 }, 1, 2);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        QuickSelectTopK s = new QuickSelectTopK();
        int ans = s.quickTopKth(new int[] { 4, 6, 3, 1, 5, 2 }, 1, 6);
        assertEquals(6, ans);
    }
}
