package com.zhangliang.google;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class extentionWordExistTest {

    @Test
    public void testCase() {
        extentionWordExist s = new extentionWordExist();
        boolean ans = s.solve(new String[] {"heello", "hi", "word"}, "heellooo");
        assertEquals(true, ans);
    }
}
