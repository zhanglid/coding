package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class HappyNumberTest {

    @Test
    public void testCase() {
        HappyNumber s = new HappyNumber();
        boolean ans = s.isHappy(19);
        assertEquals(true, ans);
    }
}
