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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        LinkedList<Integer> xPosList = new LinkedList<>();
        LinkedList<TreeNode> nodeList = new LinkedList<>();
        List<List<int[]>> ansList = new LinkedList<>();
        nodeList.add(root);
        xPosList.add(0);
        ansList.add(new ArrayList<>());
        int level = 0;
        int minXPos = 0;
        int maxXPos = 0;
        while (!nodeList.isEmpty()) {
            int size = nodeList.size();
            for (int i = 0; i < size; i++) {
                int xPos = xPosList.poll();
                TreeNode node = nodeList.poll();
                if (xPos < minXPos) {
                    ansList.add(0, new ArrayList<>());
                    minXPos = xPos;
                }
                if (xPos > maxXPos) {
                    ansList.add(new ArrayList<>());
                    maxXPos = xPos;
                }
                ansList.get(xPos - minXPos).add(new int[] { node.val, level });
                if (node.left != null) {
                    nodeList.add(node.left);
                    xPosList.add(xPos - 1);
                }
                if (node.right != null) {
                    nodeList.add(node.right);
                    xPosList.add(xPos + 1);
                }
            }
            level++;
        }
        for (int i = 0; i < ansList.size(); i++) {
            Collections.sort(ansList.get(i), new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    int levelDiff = a[1] - b[1];
                    if (levelDiff != 0) {
                        return levelDiff;
                    }
                    return a[0] - b[0];
                }
            });
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < ansList.size(); i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < ansList.get(i).size(); j++) {
                ans.get(i).add(ansList.get(i).get(j)[0]);
            }
        }
        return ans;
    }
}
