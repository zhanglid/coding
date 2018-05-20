package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidSudokuTest {

    @Test
    public void testCase() {
        ValidSudoku s = new ValidSudoku();
        char[][] input = { 
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' } 
            };
        boolean ans = s.isValidSudoku(input);
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        ValidSudoku s = new ValidSudoku();
        char[][] input = { 
            { '8','3','.','.','7','.','.','.','.' },
            { '6','.','.','1','9','5','.','.','.' },
            { '.','9','8','.','.','.','.','6','.' },
            { '8','.','.','.','6','.','.','.','3' },
            { '4','.','.','8','.','3','.','.','1' },
            { '7','.','.','.','2','.','.','.','6' },
            { '.','6','.','.','.','.','2','8','.' },
            { '.','.','.','4','1','9','.','.','5' },
            { '.','.','.','.','8','.','.','7','9' }
        };
        boolean ans = s.isValidSudoku(input);
        assertEquals(false, ans);
    }
}
