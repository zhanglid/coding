package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NQueensIITest {

    @Test
    public void testCase() {
        NQueensII s = new NQueensII();
        int ans = s.totalNQueens(4);
        assertEquals(2, ans);
    }
}
