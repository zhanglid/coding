package com.zhangliang.leetcode;

import static org.junit.Assert.assertArrayEquals;
import java.util.*;

import com.zhangliang.utils.TreeNode;

import org.junit.Test;

public class DeleteNodesAndReturnForestTest {

    private void assertCorrect(Integer[][] expected, List<TreeNode> result) {
        String[] expectedNodes = new String[expected.length];
        for (int i = 0; i < expected.length; i++) {
            expectedNodes[i] = (new TreeNode(expected[i])).toString();
        }
        String[] actualNodes = new String[result.size()];
        for (int i = 0; i < result.size(); i++) {
            actualNodes[i] = result.get(i).toString();
        }
        Arrays.sort(expectedNodes);
        Arrays.sort(actualNodes);
        assertArrayEquals(expectedNodes, actualNodes);
    }

    @Test
    public void testCase() {
        DeleteNodesAndReturnForest s = new DeleteNodesAndReturnForest();
        List<TreeNode> ans = s.delNodes(new TreeNode(new Integer[] { 1, 2, 3, 4, 5, 6, 7 }), new int[] { 3, 5 });
        assertCorrect(new Integer[][] { { 1, 2, null, 4 }, { 6 }, { 7 } }, ans);
    }
}
