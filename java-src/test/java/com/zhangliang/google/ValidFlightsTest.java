package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ValidFlightsTest {

    @Test
    public void testCase() {
        ValidFlights s = new ValidFlights();
        String ans = s.solve();
        assertEquals("", ans);
    }
}
