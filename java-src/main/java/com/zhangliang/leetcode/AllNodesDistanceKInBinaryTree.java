package com.zhangliang.leetcode;
/*
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  
The answer can be returned in any order.

Example 1:

      3
    /   \
   5     1
  / \   / \
 6  2  0   8
   / \
  7   4

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.

Note:

The given tree is non-empty.
Each node in the tree has unique values 0 <= node.val <= 500.
The target node is a node in the tree.
0 <= K <= 1000.
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class AllNodesDistanceKInBinaryTree {
    private List<TreeNode> findDistanceKNodes(TreeNode root, int K) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (K < 0) {
            return queue;
        }
        queue.add(root);
        while (K > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollFirst();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            K--;
        }
        return queue;
    }

    private int helper(TreeNode root, TreeNode target, int K, List<TreeNode> result) {
        int dist = -1;
        if (root == target) {
            result.addAll(findDistanceKNodes(root, K));
            dist = 0;
        } else {
            if (root.left != null) {
                int val = helper(root.left, target, K, result);
                if (val >= 0) {
                    if (K >= val + 2 && root.right != null) {
                        result.addAll(findDistanceKNodes(root.right, K - 2 - val));
                    } else if (K == 1 + val) {
                        result.add(root);
                    }
                }
                if (val >= 0) {
                    dist = val + 1;
                }
            }
            if (root.right != null) {
                int val = helper(root.right, target, K, result);
                if (val >= 0) {
                    if (K >= val + 2 && root.left != null) {
                        result.addAll(findDistanceKNodes(root.left, K - 2 - val));
                    } else if (K == 1 + val) {
                        result.add(root);
                    }
                }
                if (val >= 0) {
                    dist = val + 1;
                }
            }
        }
        return dist;
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<TreeNode> result = new ArrayList<>();
        helper(root, target, K, result);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            ans.add(result.get(i).val);
        }
        return ans;
    }
}
