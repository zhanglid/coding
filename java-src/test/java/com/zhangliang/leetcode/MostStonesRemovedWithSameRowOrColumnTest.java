package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MostStonesRemovedWithSameRowOrColumnTest {

    @Test
    public void testCase() {
        MostStonesRemovedWithSameRowOrColumn s = new MostStonesRemovedWithSameRowOrColumn();
        int ans = s.removeStones(new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } });
        assertEquals(5, ans);
    }

    @Test
    public void testCase2() {
        MostStonesRemovedWithSameRowOrColumn s = new MostStonesRemovedWithSameRowOrColumn();
        int ans = s.removeStones(new int[][] { { 0, 0 }, { 0, 2 }, { 1, 1 }, { 2, 0 }, { 2, 2 } });
        assertEquals(3, ans);
    }

    @Test
    public void testCase3() {
        MostStonesRemovedWithSameRowOrColumn s = new MostStonesRemovedWithSameRowOrColumn();
        int ans = s.removeStones(new int[][] { { 0, 0 } });
        assertEquals(0, ans);
    }
}
