package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.Test;

public class AdsBudgetTest {

    @Test
    public void testCase() {
        AdsBudget s = new AdsBudget();
        int[] rewards = new int[] { 1, 2, 3 };
        int[] costs = new int[] { 1, 1, 1 };
        assertEquals(3, s.solve(rewards, costs, 1));
        assertEquals(5, s.solve(rewards, costs, 2));

    }

    @Test
    public void testCase2() {
        AdsBudget s = new AdsBudget();
        int[] rewards = new int[] { 1, 2, 3 };
        int[] costs = new int[] { 1, 1, 1 };
        assertArrayEquals(new Integer[] { 2 }, s.solveFollowUp(rewards, costs, 1).toArray(new Integer[0]));
        assertArrayEquals(new Integer[] { 2, 1 }, s.solveFollowUp(rewards, costs, 2).toArray(new Integer[0]));
    }
}
