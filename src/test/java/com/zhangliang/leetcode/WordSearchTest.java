package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class WordSearchTest {

    @Test
    public void testCase() {
        WordSearch s = new WordSearch();
        boolean ans = s.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },
                "ABCCED");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        WordSearch s = new WordSearch();
        boolean ans = s.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },
                "SEE");
        assertEquals(true, ans);
    }

    @Test
    public void testCase3() {
        WordSearch s = new WordSearch();
        boolean ans = s.exist(new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } },
                "ABCB");
        assertEquals(false, ans);
    }

    @Test
    public void errCase() {
        WordSearch s = new WordSearch();
        boolean ans = s.exist(new char[][] { 
            { 'A', 'B', 'C', 'E' }, 
            { 'S', 'F', 'E', 'S' }, 
            { 'A', 'D', 'E', 'E' } 
        },
                "ABCESEEEFS");
        assertEquals(true, ans);
    }
}
