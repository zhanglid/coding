package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VerifyingAnAlienDictionaryTest {

    @Test
    public void testCase() {
        VerifyingAnAlienDictionary s = new VerifyingAnAlienDictionary();
        boolean ans = s.isAlienSorted(new String[] { "hello", "leetcode" }, "hlabcdefgijkmnopqrstuvwxyz");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        VerifyingAnAlienDictionary s = new VerifyingAnAlienDictionary();
        boolean ans = s.isAlienSorted(new String[] { "word", "world", "row" }, "worldabcefghijkmnpqstuvxyz");
        assertEquals(false, ans);
    }

    @Test
    public void testCase3() {
        VerifyingAnAlienDictionary s = new VerifyingAnAlienDictionary();
        boolean ans = s.isAlienSorted(new String[] { "apple", "app" }, "abcdefghijklmnopqrstuvwxyz");
        assertEquals(false, ans);
    }
}
