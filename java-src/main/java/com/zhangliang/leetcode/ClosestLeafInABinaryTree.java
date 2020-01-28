package com.zhangliang.leetcode;
/*
Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node to target k in the tree.

Here, nearest to a leaf means the least number of edges travelled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf 
if it has no children.

In the following examples, the input tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.

Example 1:

Input:
root = [1, 3, 2], k = 1
Diagram of binary tree:
          1
         / \
        3   2

Output: 2 (or 3)

Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.

Example 2:

Input:
root = [1], k = 1
Output: 1

Explanation: The nearest leaf node is the root node itself.

Example 3:

Input:
root = [1,2,3,4,null,null,null,5,null,6], k = 2
Diagram of binary tree:
             1
            / \
           2   3
          /
         4
        /
       5
      /
     6

Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.
Note:
root represents a binary tree with at least 1 node and at most 1000 nodes.
Every node has a unique node.val in range [1, 1000].
There exists some node in the given binary tree for which node.val == k.
*/

import com.zhangliang.utils.TreeNode;

public class ClosestLeafInABinaryTree {
    class ReturnType {
        int distToTarget;
        int distToLeaf;
        int targetDistToLeaf;
        int leafVal;
        int targetLeafVal;

        public ReturnType() {
            distToTarget = -1;
            distToLeaf = -1;
            targetDistToLeaf = -1;
            leafVal = -1;
            targetLeafVal = -1;
        }
    }

    private ReturnType findTargetToLeaf(TreeNode root, int target) {
        ReturnType rt = new ReturnType();
        if (root == null) {
            return rt;
        }
        ReturnType lrt = findTargetToLeaf(root.left, target);
        ReturnType rrt = findTargetToLeaf(root.right, target);

        // update dist to target
        if (lrt.distToTarget >= 0) {
            rt.distToTarget = lrt.distToTarget + 1;
        } else if (rrt.distToTarget >= 0) {
            rt.distToTarget = rrt.distToTarget + 1;
        } else if (root.val == target) {
            rt.distToTarget = 0;
        }

        // update dist to leaf and leafVal
        if (lrt.distToLeaf < 0 && rrt.distToLeaf < 0) {
            // root is leaf node
            rt.distToLeaf = 0;
            rt.leafVal = root.val;
        } else if (lrt.distToLeaf < 0) {
            // no left node
            rt.distToLeaf = rrt.distToLeaf + 1;
            rt.leafVal = rrt.leafVal;
        } else if (rrt.distToLeaf < 0) {
            // no right node
            rt.distToLeaf = lrt.distToLeaf + 1;
            rt.leafVal = lrt.leafVal;
        } else {
            if (lrt.distToLeaf < rrt.distToLeaf) {
                rt.distToLeaf = lrt.distToLeaf + 1;
                rt.leafVal = lrt.leafVal;
            } else {
                rt.distToLeaf = rrt.distToLeaf + 1;
                rt.leafVal = rrt.leafVal;
            }
        }

        // update targetDistToLeaf and targetLeafVal
        /**
         * 1. no values on both sides. 1) check root value. 2. one side has value. 1)
         * calculate the path through root and choose minimum. 3. both side has value -
         * never
         */
        if (lrt.targetDistToLeaf < 0 && rrt.targetDistToLeaf < 0) {
            if (root.val == target) {
                rt.targetDistToLeaf = rt.distToLeaf;
                rt.targetLeafVal = rt.leafVal;
            }
        } else if (lrt.targetDistToLeaf >= 0) {
            int distByRoot = rt.distToTarget + rrt.distToLeaf + 1;
            if (lrt.targetDistToLeaf < distByRoot || rrt.distToLeaf < 0) {
                rt.targetDistToLeaf = lrt.targetDistToLeaf;
                rt.targetLeafVal = lrt.targetLeafVal;
            } else {
                rt.targetDistToLeaf = distByRoot;
                rt.targetLeafVal = rt.leafVal;
            }
        } else if (rrt.targetDistToLeaf >= 0) {
            int distByRoot = rt.distToTarget + lrt.distToLeaf + 1;
            if (rrt.targetDistToLeaf < distByRoot || lrt.distToLeaf < 0) {
                rt.targetDistToLeaf = rrt.targetDistToLeaf;
                rt.targetLeafVal = rrt.targetLeafVal;
            } else {
                rt.targetDistToLeaf = distByRoot;
                rt.targetLeafVal = rt.leafVal;
            }
        }
        return rt;
    }

    public int findClosestLeaf(TreeNode root, int k) {
        return findTargetToLeaf(root, k).targetLeafVal;
    }
}
