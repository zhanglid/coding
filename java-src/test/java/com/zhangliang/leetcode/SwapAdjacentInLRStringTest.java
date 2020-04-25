package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class SwapAdjacentInLRStringTest {

    @Test
    public void testCase() {
        SwapAdjacentInLRString s = new SwapAdjacentInLRString();
        boolean ans = s.canTransform("RXXLRXRXL", "XRLXXRRLX");
        assertEquals(true, ans);
    }

    // The change has direction.
    @Test
    public void errCase() {
        SwapAdjacentInLRString s = new SwapAdjacentInLRString();
        boolean ans = s.canTransform("XXRXXLXXXX", "XXXXRXXLXX");
        assertEquals(false, ans);
    }
}
