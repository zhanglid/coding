package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class RestoreIPAddressesTest {

    @Test
    public void testCase() {
        RestoreIPAddresses s = new RestoreIPAddresses();
        List<String> ans = s.restoreIpAddresses("25525511135");
        Collections.sort(ans);
        assertArrayEquals(new String[] { "255.255.11.135", "255.255.111.35" }, ans.toArray(new String[0]));
    }

    @Test
    public void errCase() {
        RestoreIPAddresses s = new RestoreIPAddresses();
        List<String> ans = s.restoreIpAddresses("0279245587303");
        Collections.sort(ans);
        assertArrayEquals(new String[] {}, ans.toArray(new String[0]));
    }
}
