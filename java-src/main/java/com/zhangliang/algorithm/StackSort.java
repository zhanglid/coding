package com.zhangliang.algorithm;
/*
  Assumptions: 
    Numbers are stored in stack1, using additional stack to sort it.

  Approach: 
    Selection sort approach. Pop all numbers from stack1 into stack2 to get the minimum value. Push numbers back to stack1.

  DataStructure: 
    Stack

  Complexity: 
      Time: O(n^2)
      Space: O(n)
*/

import java.util.*;

public class StackSort {
  /**
   * Output result should be sorted in non-decreasing order
   * 
   * @param stack1 - Stack holds the original numbers.
   * @param stack2 - Empty stack to store the result.
   */
  public void sort(Stack<Integer> stack1, Stack<Integer> stack2) {
    int size = stack1.size();
    for (int i = 0; i < size; i++) {

      int min = stack1.peek();
      while (!stack1.isEmpty()) {
        // Pop from Stack1 to Stack2 to find the minimum number.
        int num = stack1.pop();
        min = Math.min(num, min);
        stack2.push(num);
      }

      // Move numbers except the minimum one back to stack1.
      boolean hasMetMin = false; // Prevent duplicate
      while (stack2.size() > i) {
        int num = stack2.pop();
        if (hasMetMin || num != min) {
          stack1.push(num);
        }
        if (num == min) {
          hasMetMin = true;
        }
      }
      stack2.push(min);

    }
  }
}
