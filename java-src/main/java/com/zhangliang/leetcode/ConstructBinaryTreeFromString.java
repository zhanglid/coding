package com.zhangliang.leetcode;
/*
You need to construct a binary tree from a string consisting of 
parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed 
by zero, one or two pairs of parenthesis. The integer represents the 
root's value and a pair of parenthesis contains a child binary tree with 
the same structure.

You always start to construct the left child node of the parent first if 
it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:
       4
     /   \
    2     6
   / \   / 
  3   1 5   
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".
*/

import java.util.Stack;

import com.zhangliang.utils.TreeNode;

public class ConstructBinaryTreeFromString {
    private boolean isDigit(char x) {
        return Character.isDigit(x) || x == '-';
    }

    public TreeNode str2tree(String s) {
        if (s.length() < 1) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            } else if (isDigit(s.charAt(i))) {
                int j = i + 1;
                while (j < s.length() && isDigit(s.charAt(j))) {
                    j++;
                }
                stack.push(new TreeNode(Integer.parseInt(s.substring(i, j))));
                i = j - 1;
            } else {
                TreeNode node = stack.pop();
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
        }
        return stack.pop();
    }
}
