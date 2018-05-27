package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class GroupAnagramsTest {

    private String listToString(List<List<String>> list) {
        String[] strs = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            List<String> group = list.get(i);
            Collections.sort(group);
            strs[i] = group.toString();
        }

        Arrays.sort(strs);
        return Arrays.toString(strs);
    }

    private String expectedToString(String[][] strss) {
        for (String[] strs : strss) {
            Arrays.sort(strs);
        }
        String[] ans = new String[strss.length];
        for (int i = 0; i < strss.length; i++) {
            ans[i] = Arrays.toString(strss[i]);
        }

        Arrays.sort(ans);

        return Arrays.toString(ans);
    }

    @Test
    public void testCase() {
        GroupAnagrams s = new GroupAnagrams();
        List<List<String>> ans = s.groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" });
        String[][] expected = new String[][] { { "ate", "eat", "tea" }, { "nat", "tan" }, { "bat" }, };

        assertEquals(expectedToString(expected), listToString(ans));
    }
}
