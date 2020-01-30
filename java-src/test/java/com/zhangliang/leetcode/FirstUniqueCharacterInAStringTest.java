package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FirstUniqueCharacterInAStringTest {

    @Test
    public void testCase() {
        FirstUniqueCharacterInAString s = new FirstUniqueCharacterInAString();
        int ans = s.firstUniqChar("leetcode");
        assertEquals(0, ans);
    }

    @Test
    public void testCase2() {
        FirstUniqueCharacterInAString s = new FirstUniqueCharacterInAString();
        int ans = s.firstUniqChar("loveleetcode");
        assertEquals(2, ans);
    }
}
