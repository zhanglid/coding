package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReadNCharactersGivenRead4Test {

    @Test
    public void testCase() {
        ReadNCharactersGivenRead4 s = new ReadNCharactersGivenRead4();
        int ans = s.read(new char[] { 'a', 'b', 'c' }, 4);
        assertEquals(3, ans);
    }

    @Test
    public void testCase2() {
        ReadNCharactersGivenRead4 s = new ReadNCharactersGivenRead4();
        int ans = s.read(new char[] { 'a', 'b', 'c', 'd', 'e' }, 5);
        assertEquals(5, ans);
    }
}
