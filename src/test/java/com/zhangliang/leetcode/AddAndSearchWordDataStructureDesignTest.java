package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import com.zhangliang.leetcode.AddAndSearchWordDataStructureDesign.WordDictionary;

import org.junit.Test;

public class AddAndSearchWordDataStructureDesignTest {

    @Test
    public void testCase() {
        WordDictionary s = new WordDictionary();
        s.addWord("bad");
        s.addWord("dad");
        s.addWord("mad");
        assertEquals(false, s.search("pad"));
        assertEquals(true, s.search("bad"));
        assertEquals(true, s.search(".ad"));
        assertEquals(true, s.search("b.."));
    }
}
