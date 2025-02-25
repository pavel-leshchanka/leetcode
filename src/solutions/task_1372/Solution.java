package solutions.task_1372;

/**
 * 1372. Longest ZigZag Path in a Binary Tree
 * You are given the root of a binary tree.
 * A ZigZag path for a binary tree is defined as follow:
 * Choose any node in the binary tree and a direction (right or left).
 * If the current direction is right, move to the right child of the current node;
 * otherwise, move to the left child.
 * Change the direction from right to left or from left to right.
 * Repeat the second and third steps until you can't move in the tree.
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has
 * a length of 0).
 * Return the longest ZigZag path contained in that tree.
 */
class Solution {

    public static class TreeNode {
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

    static int count = 0;

    public int longestZigZag(TreeNode root) {
        count = 0;
        int max = Math.max(getCount(root.left, false), getCount(root.right, true));
        if (max > count) count = max;
        return count;
    }

    public int getCount(TreeNode node, boolean head) {
        if (node == null) return 0;
        int l, r;
        if (head) {
            l = getCount(node.left, false) + 1;
            r = getCount(node.right, true);
            int max = Math.max(l, r);
            if (max > count) count = max;
            return l;
        } else {
            l = getCount(node.left, false);
            r = getCount(node.right, true) + 1;
            int max = Math.max(l, r);
            if (max > count) count = max;
            return r;
        }
    }
}