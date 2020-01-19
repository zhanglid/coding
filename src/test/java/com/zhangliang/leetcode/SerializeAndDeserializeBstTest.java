package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import com.zhangliang.utils.TreeNode;
import org.junit.Test;

public class SerializeAndDeserializeBstTest {

    @Test
    public void testCase() {
        SerializeAndDeserializeBst.Codec s = new SerializeAndDeserializeBst.Codec();
        TreeNode root = new TreeNode(new Integer[] { 2, 1, 3 });
        String ans = s.serialize(root);
        assertEquals(root, s.deserialize(ans));
    }

    @Test
    public void errCase() {
        SerializeAndDeserializeBst.Codec s = new SerializeAndDeserializeBst.Codec();
        TreeNode root = null;
        String ans = s.serialize(root);
        assertEquals(root, s.deserialize(ans));
    }

    @Test
    public void testCase2() {
        SerializeAndDeserializeBst.Codec s = new SerializeAndDeserializeBst.Codec();
        TreeNode root = new TreeNode(new Integer[] { 1, null, 2 });
        String ans = s.serialize(root);
        assertEquals(root, s.deserialize(ans));
    }
}
