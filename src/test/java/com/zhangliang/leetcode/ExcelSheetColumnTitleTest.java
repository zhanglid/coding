package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ExcelSheetColumnTitleTest {

    @Test
    public void testCase() {
        ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
        String ans = s.convertToTitle(1);
        assertEquals("A", ans);
    }

    @Test
    public void testCase2() {
        ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
        String ans = s.convertToTitle(28);
        assertEquals("AB", ans);
    }

    @Test
    public void testCase3() {
        ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
        String ans = s.convertToTitle(701);
        assertEquals("ZY", ans);
    }

    @Test
    public void errCase() {
        ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
        String ans = s.convertToTitle(703);
        assertEquals("AAA", ans);
    }
}
