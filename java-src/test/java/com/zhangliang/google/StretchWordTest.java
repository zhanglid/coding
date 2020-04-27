package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StretchWordTest {

    @Test
    public void testCase() {
        StretchWord s = new StretchWord();
        String ans = s.shrank("helllllooo");
        assertEquals("helloo", ans);
    }

    @Test
    public void testCase2() {
        StretchWord s = new StretchWord();
        boolean ans = s.inDict("helllllooo", new String[] { "hello", "helo", "heloo", "helloo" });
        assertEquals(true, ans);
    }
}
