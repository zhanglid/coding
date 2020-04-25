package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import org.junit.Test;

public class TopKFrequentWordsTest {
    @Test
    public void testCase() {
        TopKFrequentWords s = new TopKFrequentWords();
        List<String> ans = s.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2);
        assertArrayEquals(new String[] { "i", "love" }, ans.toArray(new String[0]));
    }

    @Test
    public void testCase2() {
        TopKFrequentWords s = new TopKFrequentWords();
        List<String> ans = s.topKFrequent(
                new String[] { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" }, 4);
        assertArrayEquals(new String[] { "the", "is", "sunny", "day" }, ans.toArray(new String[0]));
    }

    @Test
    public void errCase() {
        TopKFrequentWords s = new TopKFrequentWords();
        List<String> ans = s.topKFrequent(new String[] { "glarko", "zlfiwwb", "nsfspyox", "pwqvwmlgri", "qggx",
                "qrkgmliewc", "zskaqzwo", "zskaqzwo", "ijy", "htpvnmozay", "jqrlad", "ccjel", "qrkgmliewc", "qkjzgws",
                "fqizrrnmif", "jqrlad", "nbuorw", "qrkgmliewc", "htpvnmozay", "nftk", "glarko", "hdemkfr", "axyak",
                "hdemkfr", "nsfspyox", "nsfspyox", "qrkgmliewc", "nftk", "nftk", "ccjel", "qrkgmliewc", "ocgjsu", "ijy",
                "glarko", "nbuorw", "nsfspyox", "qkjzgws", "qkjzgws", "fqizrrnmif", "pwqvwmlgri", "nftk", "qrkgmliewc",
                "jqrlad", "nftk", "zskaqzwo", "glarko", "nsfspyox", "zlfiwwb", "hwlvqgkdbo", "htpvnmozay", "nsfspyox",
                "zskaqzwo", "htpvnmozay", "zskaqzwo", "nbuorw", "qkjzgws", "zlfiwwb", "pwqvwmlgri", "zskaqzwo",
                "qengse", "glarko", "qkjzgws", "pwqvwmlgri", "fqizrrnmif", "nbuorw", "nftk", "ijy", "hdemkfr", "nftk",
                "qkjzgws", "jqrlad", "nftk", "ccjel", "qggx", "ijy", "qengse", "nftk", "htpvnmozay", "qengse", "eonrg",
                "qengse", "fqizrrnmif", "hwlvqgkdbo", "qengse", "qengse", "qggx", "qkjzgws", "qggx", "pwqvwmlgri",
                "htpvnmozay", "qrkgmliewc", "qengse", "fqizrrnmif", "qkjzgws", "qengse", "nftk", "htpvnmozay", "qggx",
                "zlfiwwb", "bwp", "ocgjsu", "qrkgmliewc", "ccjel", "hdemkfr", "nsfspyox", "hdemkfr", "qggx", "zlfiwwb",
                "nsfspyox", "ijy", "qkjzgws", "fqizrrnmif", "qkjzgws", "qrkgmliewc", "glarko", "hdemkfr",
                "pwqvwmlgri" }, 14);
        assertArrayEquals(
                new String[] { "nftk", "qkjzgws", "qrkgmliewc", "nsfspyox", "qengse", "htpvnmozay", "fqizrrnmif",
                        "glarko", "hdemkfr", "pwqvwmlgri", "qggx", "zskaqzwo", "ijy", "zlfiwwb" },
                ans.toArray(new String[0]));
    }
}
