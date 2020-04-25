package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class ImplementTrieTest {

    @Test
    public void testCase() {
        ImplementTrie.Trie trie = new ImplementTrie.Trie();
        trie.insert("apple");
        assertEquals(true, trie.search("apple")); // returns true
        assertEquals(false, trie.search("app")); // returns true
        assertEquals(true, trie.startsWith("app")); // returns true
        trie.insert("app");
        assertEquals(true, trie.search("app")); // returns true
    }
}
