package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ZigZagConversionTest{

    @Test
    public void testCase() {
		ZigZagConversion s = new ZigZagConversion();
		String ans = s.convert("PAYPALISHIRING", 3);
        assertEquals(ans, "PAHNAPLSIIGYIR");
    }

    @Test
    public void testCase2() {
		ZigZagConversion s = new ZigZagConversion();
		String ans = s.convert("PAYPALISHIRING", 4);
        assertEquals(ans, "PINALSIGYAHRPI");
    }

    @Test
    public void errCase() {
		ZigZagConversion s = new ZigZagConversion();
		String ans = s.convert("A", 1);
        assertEquals(ans, "A");
    }
}
