package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class LeftDiagonallyPrintAListOfStringTest {

    @Test
    public void testCase() {
        LeftDiagonallyPrintAListOfString s = new LeftDiagonallyPrintAListOfString();
        String ans = s.solve(new String[] {"abc", "def", "gh", "i"});
        assertEquals("abdcegfhi", ans);
    }
}
