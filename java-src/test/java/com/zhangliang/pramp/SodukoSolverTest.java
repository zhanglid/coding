package com.zhangliang.pramp;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class SodukoSolverTest {

    @Test
    public void testCase() {
        SodukoSolver s = new SodukoSolver();
        char[][] input = { 
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, 
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, 
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, 
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, 
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
        boolean ans = s.sudokuSolve(input);
        assertEquals(true, ans);
    }
}
