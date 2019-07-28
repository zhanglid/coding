package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.Test;

public class AccountsMergeTest {
    private void assertCorrect(String[][] expected, List<List<String>> ans) {
        Map<String, String[]> emailAccs = new HashMap<>();
        for (String[] account : expected) {
            emailAccs.put(account[1], account);
        }
        for (List<String> account : ans) {
            assertEquals(Arrays.toString(emailAccs.get(account.get(1))), account.toString());
        }
    }

    @Test
    public void testCase() {
        AccountsMerge s = new AccountsMerge();
        List<List<String>> ans = s
                .accountsMerge(Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                        Arrays.asList("John", "johnnybravo@mail.com"),
                        Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                        Arrays.asList("Mary", "mary@mail.com")));
        String[][] expected = { { "Mary", "mary@mail.com" }, { "John", "johnnybravo@mail.com" },
                { "John", "john00@mail.com", "john_newyork@mail.com", "johnsmith@mail.com" } };
        assertCorrect(expected, ans);
    }
}
