package com.zhangliang.lintcode;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;

import com.zhangliang.utils.SegmentTreeNode;

import org.junit.Test;

public class SegmentTreeBuildTest {

    @Test
    public void testCase() {
        SegmentTreeBuild s = new SegmentTreeBuild();
        SegmentTreeNode ans = s.build(0, 3);
        assertEquals("[[0, 3], [0, 1], [2, 3], [0, 0], [1, 1], [2, 2], [3, 3]]", ans.toString());
    }
}
