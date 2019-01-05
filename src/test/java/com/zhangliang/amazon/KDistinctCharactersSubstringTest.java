package com.zhangliang.amazon;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class KDistinctCharactersSubstringTest {

    @Test
    public void testCase() {
        int ans = KDistinctCharactersSubstring.countkDist("abc", 2);
        assertEquals(2, ans);
    }

    @Test
    public void testCase2() {
        int ans = KDistinctCharactersSubstring.countkDist("aba", 2);
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        int ans = KDistinctCharactersSubstring.countkDist("aa", 1);
        assertEquals(3, ans);
    }
}
