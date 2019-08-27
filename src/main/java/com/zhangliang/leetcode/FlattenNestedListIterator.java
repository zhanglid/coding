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
        class NestedListIteratorState {
            List<NestedInteger> nestedList;
            int index;

            public NestedListIteratorState(List<NestedInteger> nestedList) {
                this.nestedList = nestedList;
            }

            public boolean isValid() {
                return nestedList != null && index < nestedList.size();
            }
        }

        private Stack<NestedListIteratorState> stack = new Stack<>();
        private NestedListIteratorState state;

        private void moveToInteger() {
            while (!state.isValid() && !stack.isEmpty()
                    || state.isValid() && !state.nestedList.get(state.index).isInteger()) {
                if (!state.isValid() && !stack.isEmpty()) {
                    state = stack.pop();
                    moveToInteger();
                } else {
                    stack.push(state);
                    state = new NestedListIteratorState(state.nestedList.get(state.index).getList());
                    stack.peek().index++;
                }
            }
        }

        private void moveToNext() {
            state.index++;
            moveToInteger();
        }

        public NestedIterator(List<NestedInteger> nestedList) {
            state = new NestedListIteratorState(nestedList);
            moveToInteger();
        }

        @Override
        public Integer next() {
            Integer ans = state.nestedList.get(state.index).getInteger();
            moveToNext();
            return ans;
        }

        @Override
        public boolean hasNext() {
            return state.isValid();
        }
    }

    /**
     * Your NestedIterator object will be instantiated and called as such:
     * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext()) v[f()]
     * = i.next();
     */
}
