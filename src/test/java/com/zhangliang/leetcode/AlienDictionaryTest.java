package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AlienDictionaryTest {

    @Test
    public void testCase() {
        AlienDictionary s = new AlienDictionary();
        String ans = s.alienOrder(new String[] { "wrt", "wrf", "er", "ett", "rftt" });
        assertEquals("wertf", ans);
    }

    @Test
    public void testCase2() {
        AlienDictionary s = new AlienDictionary();
        String ans = s.alienOrder(new String[] { "z", "x" });
        assertEquals("zx", ans);
    }

    @Test
    public void testCase3() {
        AlienDictionary s = new AlienDictionary();
        String ans = s.alienOrder(new String[] { "z", "x", "z" });
        assertEquals("", ans);
    }
}
