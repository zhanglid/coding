package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class IntegerToEnglishWordsTest {

    @Test
    public void testCase() {
        IntegerToEnglishWords s = new IntegerToEnglishWords();
        String ans = s.numberToWords(123);
        assertEquals("One Hundred Twenty Three", ans);
    }

    @Test
    public void testCase2() {
        IntegerToEnglishWords s = new IntegerToEnglishWords();
        String ans = s.numberToWords(12345);
        assertEquals("Twelve Thousand Three Hundred Forty Five", ans);
    }

    @Test
    public void testCase3() {
        IntegerToEnglishWords s = new IntegerToEnglishWords();
        String ans = s.numberToWords(1234567);
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", ans);
    }

    @Test
    public void testCase4() {
        IntegerToEnglishWords s = new IntegerToEnglishWords();
        String ans = s.numberToWords(1234567891);
        assertEquals(
                "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One",
                ans);
    }

    // #Review
    @Test
    public void errCase() {
        IntegerToEnglishWords s = new IntegerToEnglishWords();
        String ans = s.numberToWords(1000000);
        assertEquals("One Million", ans);
    }

    // #Review
    @Test
    public void errCase2() {
        IntegerToEnglishWords s = new IntegerToEnglishWords();
        String ans = s.numberToWords(1000010);
        assertEquals("One Million Ten", ans);
    }
}
