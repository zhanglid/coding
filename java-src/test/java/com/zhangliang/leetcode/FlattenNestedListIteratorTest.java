package com.zhangliang.leetcode;

import com.zhangliang.leetcode.FlattenNestedListIterator.NestedInteger;
import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class FlattenNestedListIteratorTest {
    @Test
    public void testCase() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))));
        nestedList.add(new NestedInteger(2));
        nestedList.add(new NestedInteger(Arrays.asList(new NestedInteger(1), new NestedInteger(1))));
        FlattenNestedListIterator.NestedIterator s = new FlattenNestedListIterator.NestedIterator(nestedList);
        List<Integer> result = new ArrayList<>();
        s.forEachRemaining(result::add);
        assertEquals(Arrays.asList(1, 1, 2, 1, 1), result);
    }

    @Test
    public void testCase2() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(1));
        nestedList.add(new NestedInteger(
                Arrays.asList(new NestedInteger(4), new NestedInteger(Arrays.asList(new NestedInteger(6))))));
        FlattenNestedListIterator.NestedIterator s = new FlattenNestedListIterator.NestedIterator(nestedList);
        List<Integer> result = new ArrayList<>();
        s.forEachRemaining(result::add);
        assertEquals(Arrays.asList(1, 4, 6), result);
    }

    @Test
    public void errCase() {
        List<NestedInteger> nestedList = new ArrayList<>();
        FlattenNestedListIterator.NestedIterator s = new FlattenNestedListIterator.NestedIterator(nestedList);
        List<Integer> result = new ArrayList<>();
        s.forEachRemaining(result::add);
        assertEquals(Arrays.asList(), result);
    }

    @Test
    public void errCase2() {
        List<NestedInteger> nestedList = new ArrayList<>();
        nestedList.add(new NestedInteger(Arrays.asList()));
        nestedList.add(new NestedInteger(3));
        FlattenNestedListIterator.NestedIterator s = new FlattenNestedListIterator.NestedIterator(nestedList);
        List<Integer> result = new ArrayList<>();
        s.forEachRemaining(result::add);
        assertEquals(Arrays.asList(3), result);
    }
}
