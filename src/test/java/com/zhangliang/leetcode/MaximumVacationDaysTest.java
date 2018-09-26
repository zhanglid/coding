package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MaximumVacationDaysTest {

    @Test
    public void testCase() {
        MaximumVacationDays s = new MaximumVacationDays();
        int ans = s.maxVacationDays(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } },
                new int[][] { { 1, 3, 1 }, { 6, 0, 3 }, { 3, 3, 3 } });
        assertEquals(12, ans);
    }

    @Test
    public void testCase2() {
        MaximumVacationDays s = new MaximumVacationDays();
        int ans = s.maxVacationDays(new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } },
                new int[][] { { 1, 1, 1 }, { 7, 7, 7 }, { 7, 7, 7 } });
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        MaximumVacationDays s = new MaximumVacationDays();
        int ans = s.maxVacationDays(new int[][] { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } },
                new int[][] { { 7, 0, 0 }, { 0, 7, 0 }, { 0, 0, 7 } });
        assertEquals(21, ans);
    }

    @Test
    public void testCase4() {
        MaximumVacationDays s = new MaximumVacationDays();
        int ans = s.maxVacationDays(
            new int[][] { 
                { 0, 1, 0 }, 
                { 0, 0, 0 }, 
                { 0, 0, 0 } 
            },
            new int[][] { 
                { 0, 0, 7 }, 
                { 2, 7, 7 }, 
                { 7, 7, 7 } 
        });
        assertEquals(16, ans);
    }
}
