package solutions.task_236;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 * two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow
 * a node to be a descendant of itself).”
 */
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        boolean eqLp = left == p;
        boolean eqLq = left == q;
        boolean eqRp = right == p;
        boolean eaRq = right == q;
        if ((eqLp || eqLq) && (eqRp || eaRq)) {
            return root;
        }
        if (root == p || root == q) return root;
        if (eqLp || eqLq) return left;
        if (eqRp || eaRq) return right;
        if (left != null) return left;
        if (right != null) return right;

        return null;
    }
}