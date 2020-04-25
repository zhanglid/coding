package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

public class SurroundedRegionsTest {

    @Test
    public void testCase() {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
                { 'X', 'O', 'X', 'X' } };
        char[][] target = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' }, { 'X', 'X', 'X', 'X' },
                { 'X', 'O', 'X', 'X' } };
        s.solve(board);
        assertArrayEquals(board, target);
    }

    @Test
    public void errCase() {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = new char[][] { { 'O' } };
        char[][] target = new char[][] { { 'O' } };
        s.solve(board);
        assertArrayEquals(board, target);
    }

    @Test
    public void errCase2() {
        SurroundedRegions s = new SurroundedRegions();
        char[][] board = new char[][] { 
            { 'X', 'O', 'X', 'X' }, 
            { 'O', 'X', 'O', 'X' }, 
            { 'X', 'O', 'X', 'O' },
            { 'O', 'X', 'O', 'X' }, 
            { 'X', 'O', 'X', 'O' }, 
            { 'O', 'X', 'O', 'X' } 
        };
        char[][] target = new char[][] { 
            { 'X', 'O', 'X', 'X' }, 
            { 'O', 'X', 'X', 'X' }, 
            { 'X', 'X', 'X', 'O' },
            { 'O', 'X', 'X', 'X' }, 
            { 'X', 'X', 'X', 'O' }, 
            { 'O', 'X', 'O', 'X' } };
        s.solve(board);
        assertArrayEquals(board, target);
    }
}
