package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DecodeStringTest {

    @Test
    public void testCase() {
        DecodeString s = new DecodeString();
        String ans = s.decode("ab(bcd){2}e");
        assertEquals("abbcdbcde", ans);
    }

    @Test
    public void testCase2() {
        DecodeString s = new DecodeString();
        String ans = s.decode("ab(c(de){2}){2}f");
        assertEquals("abcdedecdedef", ans);
    }
}
