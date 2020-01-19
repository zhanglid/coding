package com.zhangliang.leetcode;
/*
Given a nested list of integers, implement an iterator to flatten it.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Input: [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,1,2,1,1].

Example 2:
Input: [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,4,6].
*/

import java.util.*;

public class FlattenNestedListIterator {
    static class NestedInteger {
        private int val;
        private List<NestedInteger> nestedList;

        public NestedInteger(int val) {
            this.val = val;
        }

        public NestedInteger(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        // @return true if this NestedInteger holds a single integer, rather than a
        // nested list.
        public boolean isInteger() {
            return nestedList == null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a
        // single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return val;
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested
        // list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return nestedList;
        }
    }

    static class NestedIterator implements Iterator<Integer> {
        class IterStatus {
            List<NestedInteger> list;
            int index;

            public boolean isEnd() {
                return index >= list.size();
            }

            public IterStatus(List<NestedInteger> list) {
                this.list = list;
            }
        }

        Stack<IterStatus> stack = new Stack<>();

        private void ensureInteger() {
            while (!stack.isEmpty()
                    && (stack.peek().isEnd() || !stack.peek().list.get(stack.peek().index).isInteger())) {
                IterStatus status = stack.peek();
                if (status.index + 1 >= status.list.size()) {
                    stack.pop();
                }
                if (!status.isEnd()) {
                    stack.push(new IterStatus(status.list.get(status.index).getList()));
                    status.index++;
                }
            }
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            stack.push(new IterStatus(nestedList));
            ensureInteger();
        }

        @Override
        public Integer next() {
            IterStatus top = stack.peek();
            Integer value = top.list.get(top.index).getInteger();
            top.index++;
            ensureInteger();
            return value;
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
     * = i.next();
     */
}
