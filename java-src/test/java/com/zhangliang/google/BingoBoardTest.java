package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class BingoBoardTest {

    @Test
    public void testCase() {
        BingoBoard s = new BingoBoard();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
