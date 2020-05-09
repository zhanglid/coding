package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CardGameTest {

    @Test
    public void testCase() {
        CardGame s = new CardGame();
        int ans = s.solve(new int[] { 1, 1, -1, 1, 1 });
        assertEquals(2, ans);
    }
}
