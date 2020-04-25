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

    @Test
    public void errCase2() {
        RestoreIPAddresses s = new RestoreIPAddresses();
        List<String> ans = s.restoreIpAddresses("010010");
        Collections.sort(ans);
        assertArrayEquals(new String[] { "0.10.0.10", "0.100.1.0" }, ans.toArray(new String[0]));
    }

    @Test
    public void errCase3() {
        RestoreIPAddresses s = new RestoreIPAddresses();
        List<String> ans = s.restoreIpAddresses("");
        Collections.sort(ans);
        assertArrayEquals(new String[] {}, ans.toArray(new String[0]));
    }

    @Test
    public void errCase4() {
        RestoreIPAddresses s = new RestoreIPAddresses();
        List<String> ans = s.restoreIpAddresses(
                "111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        Collections.sort(ans);
        assertArrayEquals(new String[] {}, ans.toArray(new String[0]));
    }

}
