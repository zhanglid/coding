package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfSubmatricesWithAllOnesTest {
    @Test
    public void testCase() {
        NumberOfSubmatricesWithAllOnes s = new NumberOfSubmatricesWithAllOnes();
        int[][] input = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        int ans = s.solveBruteForce(input);
        assertEquals(36, ans);

        ans = s.solveDp(input);
        assertEquals(36, ans);

        ans = s.solveStack(input);
        assertEquals(36, ans);
    }

    @Test
    public void testCase2() {
        NumberOfSubmatricesWithAllOnes s = new NumberOfSubmatricesWithAllOnes();
        int[][] input = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int ans = s.solveBruteForce(input);
        assertEquals(20, ans);

        ans = s.solveDp(input);
        assertEquals(20, ans);

        ans = s.solveStack(input);
        assertEquals(20, ans);
    }
}
