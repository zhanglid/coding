package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class DesignPhoneDirectoryTest {

    @Test
    public void testCase() {
        DesignPhoneDirectory.PhoneDirectory s = new DesignPhoneDirectory.PhoneDirectory(3);
        assertEquals(0, s.get());
        assertEquals(1, s.get());
        assertEquals(2, s.get());
        s.release(2);
        assertEquals(true, s.check(2));
    }
}
