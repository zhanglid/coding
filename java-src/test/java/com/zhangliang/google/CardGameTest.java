package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class CardGameTest {

    @Test
    public void testCase() {
        CardGame s = new CardGame();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
