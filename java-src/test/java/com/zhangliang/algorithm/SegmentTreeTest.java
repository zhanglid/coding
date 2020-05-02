package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SegmentTreeTest {

    int[] values = new int[] { 1, 6, 3, 5, 4, 2 };
    Merger maxMerger = new Merger() {
        public int merge(int a, int b) {
            return Math.max(a, b);
        }

        public int rangeUpdate(int value, int delta, int lo, int hi) {
            return value + delta;
        }
    };

    Merger sumMerger = new Merger() {
        public int merge(int a, int b) {
            return a + b;
        }

        public int rangeUpdate(int value, int delta, int lo, int hi) {
            return value + delta * (hi - lo + 1);
        }
    };

    @Test
    public void buildAndQuery() {
        SegmentTree maxS = new SegmentTree(values, maxMerger);
        SegmentTree sumS = new SegmentTree(values, sumMerger);
        int ans = maxS.query(0, 3);
        assertEquals(6, ans);
        ans = sumS.query(0, 3);
        assertEquals(15, ans);
    }

    @Test
    public void update() {
        SegmentTree maxS = new SegmentTree(values, maxMerger);
        SegmentTree sumS = new SegmentTree(values, sumMerger);
        maxS.update(2, 99);
        sumS.update(2, 99);
        assertEquals(99, maxS.query(0, 3));
        assertEquals(111, sumS.query(0, 3));
    }

    @Test
    public void updateRange() {
        SegmentTree maxS = new SegmentTree(values, maxMerger);
        SegmentTree sumS = new SegmentTree(values, sumMerger);
        maxS.updateRange(0, 3, 99);
        sumS.updateRange(0, 3, 99);
        assertEquals(105, maxS.query(0, 3));
        assertEquals(411, sumS.query(0, 3));
    }
}
