package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.Arrays;
import org.junit.Test;

public class LetterCombinationsOfAPhoneNumberTest {

    @Test
    public void testCase() {
        LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();
        String[] ans = s.letterCombinations("23").toArray(new String[0]);
        String[] expected = { "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf" };
        Arrays.sort(ans);
        Arrays.sort(expected);
        assertArrayEquals(expected, ans);
    }
}
