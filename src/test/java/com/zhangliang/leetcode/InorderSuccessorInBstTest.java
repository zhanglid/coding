package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class InorderSuccessorInBstTest {

    @Test
    public void testCase() {
        InorderSuccessorInBst s = new InorderSuccessorInBst();
        TreeNode ans = s.inorderSuccessor(new TreeNode(new Integer[] { 2, 1, 3 }), new TreeNode(1));
        assertEquals(2, ans.val);
    }

    @Test
    public void testCase2() {
        InorderSuccessorInBst s = new InorderSuccessorInBst();
        TreeNode ans = s.inorderSuccessor(new TreeNode(new Integer[] { 5, 3, 6, 2, 4, null, null, 1 }),
                new TreeNode(6));
        assertEquals(null, ans);
    }
}
