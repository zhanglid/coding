package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class NumberOfIslandsTest {

    @Test
    public void testCase() {
        NumberOfIslands s = new NumberOfIslands();
        char[][] input = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
        int ans = s.numIslands(input);
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        NumberOfIslands s = new NumberOfIslands();
        char[][] input = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
        int ans = s.numIslands(input);
        assertEquals(3, ans);
    }
}
