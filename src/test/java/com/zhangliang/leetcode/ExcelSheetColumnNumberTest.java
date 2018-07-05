package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ExcelSheetColumnNumberTest {

    @Test
    public void testCase() {
        ExcelSheetColumnNumber s = new ExcelSheetColumnNumber();
        int ans = s.titleToNumber("A");
        assertEquals(1, ans);
    }

    @Test
    public void testCase2() {
        ExcelSheetColumnNumber s = new ExcelSheetColumnNumber();
        int ans = s.titleToNumber("AB");
        assertEquals(28, ans);
    }

    @Test
    public void testCase3() {
        ExcelSheetColumnNumber s = new ExcelSheetColumnNumber();
        int ans = s.titleToNumber("ZY");
        assertEquals(701, ans);
    }
}
