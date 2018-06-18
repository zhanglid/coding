package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ReadNCharactersGivenRead4IITest {

    @Test
    public void testCase() {
        ReadNCharactersGivenRead4II s = new ReadNCharactersGivenRead4II();
        char[] buf = new char[] { 'a', 'b', 'c' };
        int ans = s.read(buf, 1);
        assertEquals(1, ans);
        ans = s.read(buf, 2);
        assertEquals(0, ans);
        ans = s.read(buf, 1);
        assertEquals(0, ans);
    }

    @Test
    public void testCase2() {
        ReadNCharactersGivenRead4II s = new ReadNCharactersGivenRead4II();
        char[] buf = new char[] { 'a', 'b', 'c' };
        int ans = s.read(buf, 4);
        assertEquals(3, ans);
        ans = s.read(buf, 1);
        assertEquals(0, ans);
    }

}
