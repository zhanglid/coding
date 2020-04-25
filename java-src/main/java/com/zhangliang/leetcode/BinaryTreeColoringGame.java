package com.zhangliang.leetcode;
/*
Two players play a turn based game on a binary tree.  We are given the root of this binary tree, and the number of nodes n in the tree.  n is odd, and each node has a distinct value from 1 to n.

Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x.  The first player colors the node with value x red, and the second player colors the node with value y blue.

Then, the players take turns starting with the first player.  In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)

If (and only if) a player cannot choose such a node in this way, they must pass their turn.  If both players pass their turn, the game ends, and the winner is the player that colored more nodes.

You are the second player.  If it is possible to choose such a y to ensure you win the game, return true.  If it is not possible, return false.

 

Example 1:


Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
Output: true
Explanation: The second player can choose the node with value 2.
 

Constraints:

root is the root of a binary tree with n nodes and distinct node values from 1 to n.
n is odd.
1 <= x <= n <= 100
*/

import java.util.*;

import com.zhangliang.utils.TreeNode;

public class BinaryTreeColoringGame {
    private int getCounts(TreeNode root, Map<TreeNode, Integer> counts) {
        if (root == null) {
            return 0;
        }
        int left = getCounts(root.left, counts);
        int right = getCounts(root.right, counts);
        counts.put(root, 1 + left + right);
        return 1 + left + right;
    }

    private TreeNode findParent(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return null;
        }
        if (root.left != null && root.left.val == target || root.right != null && root.right.val == target) {
            return root;
        }
        TreeNode left = findParent(root.left, target);
        if (left != null) {
            return left;
        }
        TreeNode right = findParent(root.right, target);
        return right;
    }

    private TreeNode findNode(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }
        TreeNode left = findNode(root.left, target);
        if (left != null) {
            return left;
        }
        return findNode(root.right, target);
    }

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        Map<TreeNode, Integer> counts = new HashMap<>();
        getCounts(root, counts);
        TreeNode parent = findParent(root, x);
        TreeNode node = findNode(root, x);
        int maxCount = 0;
        if (parent != null) {
            maxCount = n - counts.get(node);
        }

        if (node.left != null) {
            maxCount = Math.max(counts.get(node.left), maxCount);
        }

        if (node.right != null) {
            maxCount = Math.max(counts.get(node.right), maxCount);
        }

        return maxCount > n - maxCount;
    }
}