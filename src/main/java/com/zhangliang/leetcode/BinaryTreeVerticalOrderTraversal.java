package com.zhangliang.leetcode;
/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by 
column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
    class IndexedTreeNode {
        int index;
        TreeNode node;

        public IndexedTreeNode(TreeNode node) {
            this.node = node;
        }

        public IndexedTreeNode(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<IndexedTreeNode> nodes = new LinkedList<>();
        Map<Integer, List<Integer>> groups = new HashMap<>();
        if (root != null) {
            nodes.add(new IndexedTreeNode(root));
        }
        int min = 0;
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                IndexedTreeNode itn = nodes.poll();
                min = Math.min(itn.index, min);
                if (!groups.containsKey(itn.index)) {
                    groups.put(itn.index, new ArrayList<>());
                }
                groups.get(itn.index).add(itn.node.val);
                if (itn.node.left != null) {
                    nodes.add(new IndexedTreeNode(itn.node.left, itn.index - 1));
                }
                if (itn.node.right != null) {
                    nodes.add(new IndexedTreeNode(itn.node.right, itn.index + 1));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (groups.containsKey(min)) {
            ans.add(groups.get(min++));
        }
        return ans;
    }
}
