package com.zhangliang.leetcode;
/*
Given a binary tree, return the vertical order traversal of its nodes values.
For each node at position (X, Y), its left and right children respectively will be at positions 
(X-1, Y-1) and (X+1, Y-1).
Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches 
some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
If two nodes have the same position, then the value of the node that is reported first is the 
value that is smaller. Return an list of non-empty reports in order of X coordinate.  Every report 
will have a list of values of nodes.

Example 1:
Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).

Example 2:
Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.

Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class VerticalOrderTraversalOfABinaryTree {
    class Token {
        TreeNode node;
        int depth;
        int pos;

        public Token(TreeNode node, int depth, int pos) {
            this.node = node;
            this.depth = depth;
            this.pos = pos;
        }
    }

    private void dfs(TreeNode root, int depth, int pos, List<Token> result) {
        if (root == null) {
            return;
        }
        result.add(new Token(root, depth, pos));
        dfs(root.left, depth + 1, pos - 1, result);
        dfs(root.right, depth + 1, pos + 1, result);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Token> tokenList = new ArrayList<>();
        dfs(root, 0, 0, tokenList);
        Collections.sort(tokenList, new Comparator<Token>() {
            public int compare(Token a, Token b) {
                if (a.pos != b.pos) {
                    return a.pos - b.pos;
                }
                if (a.depth != b.depth) {
                    return a.depth - b.depth;
                }
                return a.node.val - b.node.val;
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        if (tokenList.isEmpty()) {
            return result;
        }
        List<Integer> group = new ArrayList<>();
        int pos = tokenList.get(0).pos;
        for (Token token : tokenList) {
            if (token.pos != pos) {
                pos = token.pos;
                result.add(group);
                group = new ArrayList<>();
            }
            group.add(token.node.val);
        }
        result.add(group);
        return result;
    }
}
