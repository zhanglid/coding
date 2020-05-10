package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PossibilityDPTest {

    @Test
    public void testCase() {
        PossibilityDP s = new PossibilityDP();
        int ans = s.solve(4, 3);
        assertEquals(3, ans);
    }
}
