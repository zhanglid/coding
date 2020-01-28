package com.zhangliang.leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import com.zhangliang.leetcode.SerializeAndDeserializeNAryTree.Node;
import com.zhangliang.leetcode.SerializeAndDeserializeNAryTree.Codec;

import org.junit.Test;

public class SerializeAndDeserializeNAryTreeTest {

    @Test
    public void testCase() {
        Codec coder = new Codec();
        Node root = new Node(1, new ArrayList<>());
        root.children.add(new Node(3,
                Arrays.asList(new Node[] { new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>()) })));
        root.children.add(new Node(2, new ArrayList<>()));
        root.children.add(new Node(4, new ArrayList<>()));

        String code = coder.serialize(root);
        Node newRoot = coder.deserialize(code);
        assertEquals(true, newRoot.isEqual(root));
    }

    @Test
    public void testCase2() {
        Codec coder = new Codec();
        Node root = null;
        String code = coder.serialize(root);
        Node newRoot = coder.deserialize(code);
        assertEquals(null, newRoot);
    }
}
