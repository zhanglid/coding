package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LicenseKeyFormattingTest {

    @Test
    public void testCase() {
        LicenseKeyFormatting s = new LicenseKeyFormatting();
        String ans = s.licenseKeyFormatting("5F3Z-2e-9-w", 4);
        assertEquals("5F3Z-2E9W", ans);
    }

    @Test
    public void testCase2() {
        LicenseKeyFormatting s = new LicenseKeyFormatting();
        String ans = s.licenseKeyFormatting("2-5g-3-J", 2);
        assertEquals("2-5G-3J", ans);
    }
}
