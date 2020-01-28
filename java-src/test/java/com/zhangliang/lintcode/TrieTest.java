package com.zhangliang.lintcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class TrieTest {

    @Test
    public void testCase() {
        Trie s = new Trie();
        s.insert("lintcode");
        assertEquals(false, s.search("code"));
        assertEquals(true, s.startsWith("lint"));
        assertEquals(false, s.startsWith("linterror"));
    }

    @Test
    public void testCase2() {
        Trie s = new Trie();
        s.insert("linterror");
        assertEquals(false, s.search("lintcode"));
    }

    @Test
    public void testCase3() {
        Trie s = new Trie();
        s.insert("linterror");
        assertEquals(true, s.startsWith("linterror"));
    }
}
