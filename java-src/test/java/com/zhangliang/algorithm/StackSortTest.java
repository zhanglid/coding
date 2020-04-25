package com.zhangliang.algorithm;

import static org.junit.Assert.assertEquals;
import java.util.*;

import org.junit.Test;

public class StackSortTest {

    /**
     * Basic case
     */
    @Test
    public void testCase() {
        StackSort s = new StackSort();
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(3);
        stack1.push(2);
        stack1.push(4);
        Stack<Integer> stack2 = new Stack<>();
        s.sort(stack1, stack2);
        assertEquals("[1, 2, 3, 4]", stack2.toString());
    }

    /**
     * Duplicate elements
     */
    @Test
    public void testCase2() {
        StackSort s = new StackSort();
        Stack<Integer> stack1 = new Stack<>();
        stack1.push(1);
        stack1.push(3);
        stack1.push(2);
        stack1.push(4);
        stack1.push(2);
        Stack<Integer> stack2 = new Stack<>();
        s.sort(stack1, stack2);
        assertEquals("[1, 2, 2, 3, 4]", stack2.toString());
    }
}
