/*
Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.

Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.

You should output the root TreeNode of both subtrees after splitting, in any order.

Example 1:

Input: root = [4,2,6,1,3,5,7], V = 2
Output: [[2,1],[4,3,6,null,null,5,7]]
Explanation:
Note that root, output[0], and output[1] are TreeNode objects, not arrays.

The given tree [4,2,6,1,3,5,7] is represented by the following diagram:

          4
        /   \
      2      6
     / \    / \
    1   3  5   7

while the diagrams for the outputs are:

          4
        /   \
      3      6      and    2
            / \           /
           5   7         1
Note:

The size of the BST will not exceed 50.
The BST is always valid and each node's value is different.

*/

/*
*  Solution: 递归返回split的结果。根据root和V比对大小，如果小则在左子树里找，并且把root.left接到大的一半上。
*            如果大，在右子树里找。然后把剩余的接到小的一部分，保留大的。
*
*  Corner Case: 
*
*  Complexity: O(log(n))
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SplitBST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null)
            return new TreeNode[2];
        TreeNode[] ans = new TreeNode[2];
        if (V < root.val) {
            TreeNode[] left = splitBST(root.left, V);
            ans[0] = left[0];
            root.left = left[1];
            ans[1] = root;
        }
        else if (V > root.val) {
            TreeNode[] right = splitBST(root.right, V);
            ans[1] = right[1];
            root.right = right[0];
            ans[0] = root;
        }
        else {
            ans[1] = root.right;
            root.right = null;
            ans[0] = root;
        }
        
        return ans;
    }
}