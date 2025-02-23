package solutions.task_872;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 872. Leaf-Similar Trees
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
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

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return createList(root1).equals(createList(root2));
    }

    public List<Integer> createList(TreeNode node) {
        Stack<TreeNode> objects1 = new Stack<>();
        objects1.push(node);
        List<Integer> objects = new ArrayList<>();

        while (!objects1.empty()) {
            TreeNode pop = objects1.pop();

            if (pop.left == null && pop.right == null) {
                objects.add(pop.val);
            }
            if (pop.right != null) {
                objects1.push(pop.right);
            }
            if (pop.left != null) {
                objects1.push(pop.left);
            }
        }
        return objects;
    }
}