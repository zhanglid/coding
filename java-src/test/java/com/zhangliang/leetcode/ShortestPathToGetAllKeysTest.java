package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ShortestPathToGetAllKeysTest {

    @Test
    public void testCase() {
        ShortestPathToGetAllKeys s = new ShortestPathToGetAllKeys();
        int ans = s.shortestPathAllKeys(new String[] { "@.a.#", "###.#", "b.A.B" });
        assertEquals(8, ans);
    }

    @Test
    public void testCase2() {
        ShortestPathToGetAllKeys s = new ShortestPathToGetAllKeys();
        int ans = s.shortestPathAllKeys(new String[] { "@..aA", "..B#.", "....b" });
        assertEquals(6, ans);
    }

    @Test
    public void errCase() {
        ShortestPathToGetAllKeys s = new ShortestPathToGetAllKeys();
        int ans = s.shortestPathAllKeys(new String[] { 
            "@...a", 
            ".###A", 
            "b.BCc" 
        });
        assertEquals(10, ans);
    }
}
