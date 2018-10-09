package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MinesweeperTest {

    @Test
    public void testCase() {
        Minesweeper s = new Minesweeper();
        char[][] ans = s.updateBoard(new char[][] { 
            { 'E', 'E', 'E', 'E', 'E' }, 
            { 'E', 'E', 'M', 'E', 'E' },
            { 'E', 'E', 'E', 'E', 'E' }, 
            { 'E', 'E', 'E', 'E', 'E' } 
        }, new int[]{3, 0});
        char[][] expected = { 
            { 'B', '1', 'E', '1', 'B' }, 
            { 'B', '1', 'M', '1', 'B' }, 
            { 'B', '1', '1', '1', 'B' },
            { 'B', 'B', 'B', 'B', 'B' } 
        };
        assertArrayEquals(expected, ans);
    }

    @Test
    public void testCase2() {
        Minesweeper s = new Minesweeper();
        char[][] ans = s.updateBoard(new char[][] { 
            { 'B', '1', 'E', '1', 'B' },
            { 'B', '1', 'M', '1', 'B' },
            { 'B', '1', '1', '1', 'B' },
            { 'B', 'B', 'B', 'B', 'B' }
        }, new int[]{ 1, 2 });
        char[][] expected = { 
            { 'B', '1', 'E', '1', 'B' },
            { 'B', '1', 'X', '1', 'B' },
            { 'B', '1', '1', '1', 'B' },
            { 'B', 'B', 'B', 'B', 'B' }
        };
        assertArrayEquals(expected, ans);
    }
}
