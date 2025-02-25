package solutions.task_450;

/**
 * 450. Delete Node in a BST
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
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


    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null && root.right == null) return null;
            if (root.right == null) {
                return root.left;
            }
            if (root.left == null) {
                return root.right;
            }
            TreeNode treeNode = findMaxOfLeft(root.left);
            root.val = treeNode.val;
            root.left = deleteNode(root.left, treeNode.val);
            return root;
        } else {
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    private TreeNode findMaxOfLeft(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

}