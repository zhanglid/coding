package com.zhangliang.linkedin;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;
import org.junit.Test;

public class DuplicatedSubstringWithGivenLengthTest {

    @Test
    public void testCase() {
        DuplicatedSubstringWithGivenLength s = new DuplicatedSubstringWithGivenLength();
        List<String> ans = s.getAllDuplicatedSubstring("aaaaaaaaaaa");
        assertArrayEquals(new String[] { "aaaaaaaaaaa" }, ans.toArray(new String[0]));
    }
}
