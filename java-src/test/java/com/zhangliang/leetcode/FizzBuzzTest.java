package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.List;

import org.junit.Test;

public class FizzBuzzTest {

    @Test
    public void testCase() {
        FizzBuzz s = new FizzBuzz();
        List<String> ans = s.fizzBuzz(15);
        assertArrayEquals(new String[] { "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz",
                "13", "14", "FizzBuzz" }, ans.toArray(new String[0]));
    }
}
