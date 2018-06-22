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
}
