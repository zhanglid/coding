package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class RemoveUpperLowerTest {

    @Test
    public void testCase() {
        RemoveUpperLower s = new RemoveUpperLower();
        String ans = s.removeUpperLower("AaAaaa");
        assertEquals("aa", ans);
    }

    @Test
    public void testCase2() {
        RemoveUpperLower s = new RemoveUpperLower();
        String ans = s.removeUpperLower("Aa");
        assertEquals("", ans);
    }

    @Test
    public void testCase3() {
        RemoveUpperLower s = new RemoveUpperLower();
        String ans = s.repeatedlyRemoveUpperLower("AAAaaa");
        assertEquals("", ans);
        ans = s.repeatedlyRemoveUpperLower2("AAAaaa");
        assertEquals("", ans);
    }

    @Test
    public void testCase4() {
        RemoveUpperLower s = new RemoveUpperLower();
        String ans = s.repeatedlyRemoveUpperLower("Caac");
        assertEquals("Caac", ans);
        ans = s.repeatedlyRemoveUpperLower2("AAAaaa");
        assertEquals("", ans);
    }
}
