package com.zhangliang.leetcode;
/*
Implement FreqStack, a class which simulates the operation of a stack-like data structure.

FreqStack has two functions:

push(int x), which pushes an integer x onto the stack.
pop(), which removes and returns the most frequent element in the stack.
If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 

Example 1:

Input: 
["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
[[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
Output: [null,null,null,null,null,null,null,5,7,5,4]
Explanation:
After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:

pop() -> returns 5, as 5 is the most frequent.
The stack becomes [5,7,5,7,4].

pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
The stack becomes [5,7,5,4].

pop() -> returns 5.
The stack becomes [5,7,4].

pop() -> returns 4.
The stack becomes [5,7].
 

Note:

Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
The total number of FreqStack.push calls will not exceed 10000 in a single test case.
The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.

*/

import java.util.*;

public class MaximumFrequencyStack {
    static class FreqStack {
        class Node {
            Node next;
            Node prev;
            int value;
            List<Integer> valueList;

            public Node(int value) {
                valueList = new ArrayList<>();
                this.value = value;
            }
        }

        Node head;
        Node tail;
        Map<Integer, List<Node>> nodeMap;

        public FreqStack() {
            head = new Node(0);
            tail = head;
            nodeMap = new HashMap<>();
        }

        private void ensureValueAfter(Node node, int value) {
            Node next = node.next;
            if (next == null || next.value != value) {
                node.next = new Node(value);
                node.next.prev = node;
                node.next.next = next;
                if (next != null) {
                    next.prev = node.next;
                } else {
                    tail = node.next;
                }
            }
        }

        public void push(int x) {
            Node node = nodeMap.containsKey(x) ? nodeMap.get(x).get(nodeMap.get(x).size() - 1) : head;
            ensureValueAfter(node, node.value + 1);
            node.next.valueList.add(x);
            if (!nodeMap.containsKey(x)) {
                nodeMap.put(x, new ArrayList<>());
            }
            nodeMap.get(x).add(node.next);
        }

        public int pop() {
            int value = tail.valueList.get(tail.valueList.size() - 1);
            tail.valueList.remove(tail.valueList.size() - 1);
            nodeMap.get(value).remove(nodeMap.get(value).size() - 1);
            if (tail.valueList.isEmpty()) {
                tail = tail.prev;
                tail.next = null;
            }
            if (nodeMap.get(value).isEmpty()) {
                nodeMap.remove(value);
            }
            return value;
        }
    }

    /**
     * Your FreqStack object will be instantiated and called as such: FreqStack obj
     * = new FreqStack(); obj.push(x); int param_2 = obj.pop();
     */
}
