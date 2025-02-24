package solutions.task_1148;

/**
 * 1448. Count Good Nodes in Binary Tree
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X
 * there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
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


    public int goodNodes(TreeNode root) {
        return node(root, Integer.MIN_VALUE);
    }

    public int node(TreeNode node, int val) {
        int count = 0;
        int value = Math.max(node.val, val);
        if (value == node.val) count++;
        if (node.left != null) {
            count += node(node.left, value);
        }
        if (node.right != null) {
            count += node(node.right, value);
        }
        return count;
    }
}