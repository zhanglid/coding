package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class AccountsMergeTest {
    private void assertCorrect(String[][] expected, List<List<String>> ans) {
        Map<String, String[]> emailAccs = new HashMap<>();
        for (String[] account : expected) {
            String[] emails = new String[account.length - 1];
            for (int i = 1; i < account.length; i++) {
                emails[i - 1] = account[i];
            }
            Arrays.sort(emails);
            for (int i = 0; i < emails.length; i++) {
                emailAccs.put(emails[i], emails);
            }
        }
        for (List<String> account : ans) {
            String[] emails = new String[account.size() - 1];
            for (int i = 1; i < account.size(); i++) {
                emails[i - 1] = account.get(i);
            }
            Arrays.sort(emails);
            assertArrayEquals(emailAccs.get(emails[0]), emails);
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
