package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class IpAddressBlacklistMatchingTest {

    @Test
    public void testCase() {
        IpAddressBlacklistMatching s = new IpAddressBlacklistMatching();
        boolean ans = s.solve("192.168.1.1", "192.168.1.*");
        assertEquals(true, ans);
    }

    @Test
    public void testCase2() {
        IpAddressBlacklistMatching s = new IpAddressBlacklistMatching();
        boolean ans = s.solve("192.168.1.1", "192.168.2.*");
        assertEquals(false, ans);
    }
}
