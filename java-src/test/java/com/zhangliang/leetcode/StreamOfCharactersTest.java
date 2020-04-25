package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StreamOfCharactersTest {

    @Test
    public void testCase() {
        StreamOfCharacters.StreamChecker s = new StreamOfCharacters.StreamChecker(new String[] { "cd", "f", "kl" });
        assertEquals(s.query('a'), false);
        assertEquals(s.query('b'), false);
        assertEquals(s.query('c'), false);
        assertEquals(s.query('d'), true);
        assertEquals(s.query('e'), false);
        assertEquals(s.query('f'), true);
        assertEquals(s.query('g'), false);
        assertEquals(s.query('h'), false);
        assertEquals(s.query('i'), false);
        assertEquals(s.query('j'), false);
        assertEquals(s.query('k'), false);
        assertEquals(s.query('l'), true);
    }
}
