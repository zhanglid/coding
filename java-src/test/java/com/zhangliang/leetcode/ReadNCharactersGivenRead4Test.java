package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReadNCharactersGivenRead4Test {

    @Test
    public void testCase() {
        ReadNCharactersGivenRead4 s = new ReadNCharactersGivenRead4("abc".toCharArray());
        char[] buf = new char[3];
        int ans = s.read(buf, 4);
        assertEquals(ans, 3);
        assertArrayEquals(buf, "abc".toCharArray());
    }

    @Test
    public void testCase2() {
        ReadNCharactersGivenRead4 s = new ReadNCharactersGivenRead4("abcde".toCharArray());
        char[] buf = new char[5];
        int ans = s.read(buf, 5);
        assertEquals(ans, 5);
        assertArrayEquals(buf, "abcde".toCharArray());
    }

    @Test
    public void testCase3() {
        ReadNCharactersGivenRead4 s = new ReadNCharactersGivenRead4("abcdABCD1234".toCharArray());
        char[] buf = new char[12];
        int ans = s.read(buf, 12);
        assertEquals(ans, 12);
        assertArrayEquals(buf, "abcdABCD1234".toCharArray());
    }

    @Test
    public void testCase4() {
        ReadNCharactersGivenRead4 s = new ReadNCharactersGivenRead4("leetcode".toCharArray());
        char[] buf = new char[5];
        int ans = s.read(buf, 5);
        assertEquals(ans, 5);
        assertArrayEquals(buf, "leetc".toCharArray());
    }
}
