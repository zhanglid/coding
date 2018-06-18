package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ReadNCharactersGivenRead4IITest {

    @Test
    public void testCase() {
        ReadNCharactersGivenRead4II s = new ReadNCharactersGivenRead4II(new char[] { 'a', 'b', 'c' });
        char[] buf = new char[4];
        int ans = s.read(buf, 1);
        assertEquals(1, ans);
        ans = s.read(buf, 2);
        assertEquals(2, ans);
        ans = s.read(buf, 1);
        assertEquals(0, ans);
    }

    @Test
    public void testCase2() {
        ReadNCharactersGivenRead4II s = new ReadNCharactersGivenRead4II(new char[] { 'a', 'b', 'c' });
        char[] buf = new char[4];
        int ans = s.read(buf, 4);
        assertEquals(3, ans);
        ans = s.read(buf, 1);
        assertEquals(0, ans);
    }

    @Test
    public void errCase() {
        ReadNCharactersGivenRead4II s = new ReadNCharactersGivenRead4II(new char[] {});
        char[] buf = new char[4];
        int ans = s.read(buf, 1);
        assertEquals(0, ans);
    }

    @Test
    public void errCase2() {
        ReadNCharactersGivenRead4II s = new ReadNCharactersGivenRead4II(new char[] { 'a', 'b' });
        char[] buf = new char[4];
        int ans = s.read(buf, 1);
        assertEquals(1, ans);
        ans = s.read(buf, 2);
        assertEquals(1, ans);
    }
}
