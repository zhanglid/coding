package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class DesignSearchAutocompleteSystemTest {

    private void assertCorrect(String[] strings, List<String> list) {
        assertArrayEquals(strings, list.toArray(new String[0]));
    }

    @Test
    public void testCase() {
        DesignSearchAutocompleteSystem.AutocompleteSystem s = new DesignSearchAutocompleteSystem.AutocompleteSystem(
                new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });
        List<String> ans = s.input('i');
        assertCorrect(new String[] { "i love you", "island", "i love leetcode" }, ans);
        ans = s.input(' ');
        assertCorrect(new String[] { "i love you", "i love leetcode" }, ans);
        ans = s.input('a');
        assertCorrect(new String[] {}, ans);
        ans = s.input('#');
        assertCorrect(new String[] {}, ans);
    }

}
