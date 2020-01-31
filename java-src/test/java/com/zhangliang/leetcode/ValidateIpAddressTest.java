package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ValidateIpAddressTest {

    @Test
    public void testCase() {
        ValidateIpAddress s = new ValidateIpAddress();
        String ans = s.validIPAddress("172.16.254.1");
        assertEquals("IPv4", ans);
    }

    @Test
    public void testCase2() {
        ValidateIpAddress s = new ValidateIpAddress();
        String ans = s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
        assertEquals("IPv6", ans);
    }

    @Test
    public void testCase3() {
        ValidateIpAddress s = new ValidateIpAddress();
        String ans = s.validIPAddress("256.256.256.256");
        assertEquals("Neither", ans);
    }

    @Test
    public void errCase() {
        ValidateIpAddress s = new ValidateIpAddress();
        String ans = s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:");
        assertEquals("Neither", ans);
    }

    @Test
    public void errCase2() {
        ValidateIpAddress s = new ValidateIpAddress();
        String ans = s.validIPAddress("00.0.0.0");
        assertEquals("Neither", ans);
    }

    @Test
    public void errCase3() {
        ValidateIpAddress s = new ValidateIpAddress();
        String ans = s.validIPAddress("1.1.1.1.");
        assertEquals("Neither", ans);
    }
}
