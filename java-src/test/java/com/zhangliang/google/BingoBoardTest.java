package com.zhangliang.google;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class BingoBoardTest {

    @Test
    public void testCase() {
        BingoBoard s = new BingoBoard();
        int[][] ans = s.generate();
        System.out.println(Arrays.deepToString(ans));
    }
}
