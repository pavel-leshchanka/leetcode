package solutions.task_700;

/**
 * 700. Search in a Binary Search Tree
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        TreeNode treeNode1 = searchBST(root.left, val);
        TreeNode treeNode2 = searchBST(root.right, val);
        if (treeNode1 != null && treeNode1.val == val) return treeNode1;
        if (treeNode2 != null && treeNode2.val == val) return treeNode2;
        return null;
    }
}