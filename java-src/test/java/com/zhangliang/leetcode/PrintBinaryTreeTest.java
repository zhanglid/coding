package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.List;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class PrintBinaryTreeTest {

    private void assertCorrect(String[][] expected, List<List<String>> actual) {
        assertEquals(expected.length, actual.size());
        for (int i = 0; i < expected.length; i++) {
            assertArrayEquals(expected[i], actual.get(i).toArray(new String[0]));
        }
    }

    @Test
    public void testCase() {
        PrintBinaryTree s = new PrintBinaryTree();
        List<List<String>> ans = s.printTree(new TreeNode(new Integer[] { 1, 2, 3, null, 4 }));
        assertCorrect((new String[][] { { "", "", "", "1", "", "", "" }, { "", "2", "", "", "", "3", "" },
                { "", "", "4", "", "", "", "" } }), ans);
    }

    @Test
    public void testCase2() {
        PrintBinaryTree s = new PrintBinaryTree();
        List<List<String>> ans = s.printTree(new TreeNode(new Integer[] { 1, 2, 3, null, 4 }));
        assertCorrect((new String[][] { { "", "", "", "1", "", "", "" }, { "", "2", "", "", "", "3", "" },
                { "", "", "4", "", "", "", "" } }), ans);
    }

    @Test
    public void testCase3() {
        PrintBinaryTree s = new PrintBinaryTree();
        List<List<String>> ans = s.printTree(new TreeNode(new Integer[] { 1, 2, 5, 3, null, null, null, 4 }));
        assertCorrect(new String[][] { { "", "", "", "", "", "", "", "1", "", "", "", "", "", "", "" },
                { "", "", "", "2", "", "", "", "", "", "", "", "5", "", "", "" },
                { "", "3", "", "", "", "", "", "", "", "", "", "", "", "", "" },
                { "4", "", "", "", "", "", "", "", "", "", "", "", "", "", "" } }, ans);
    }
}
