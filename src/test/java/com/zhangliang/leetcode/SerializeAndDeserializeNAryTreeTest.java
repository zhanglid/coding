package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.leetcode.SerializeAndDeserializeNAryTree.Node;
import com.zhangliang.leetcode.SerializeAndDeserializeNAryTree.Codec;

import org.junit.Test;

public class SerializeAndDeserializeNAryTreeTest {

    @Test
    public void testCase() {
        Node root = new Node(1, null);
        Codec coder = new Codec();
        root.children.add(new Node(3, Arrays.asList(new Node[] { new Node(5, null), new Node(6, null) })));
        root.children.add(new Node(2, null));
        root.children.add(new Node(4, null));

        String code = coder.serialize(root);
        Node newRoot = coder.deserialize(code);
        assertEquals(true, newRoot.isEqual(root));
    }
}
