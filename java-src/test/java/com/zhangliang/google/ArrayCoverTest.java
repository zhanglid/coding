package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ArrayCoverTest {

    @Test
    public void testCase() {
        ArrayCover s = new ArrayCover();
        int ans = s.solve(new int[] { 1, 1, 2, 1, 1 });
        assertEquals(1, ans);
    }
}
