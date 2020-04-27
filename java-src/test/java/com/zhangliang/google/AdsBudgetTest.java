package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class AdsBudgetTest {

    @Test
    public void testCase() {
        AdsBudget s = new AdsBudget();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
