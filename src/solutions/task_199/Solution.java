package solutions.task_199;

import java.util.ArrayList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        addVal(root, integers, 0);
        return integers;
    }

    private void addVal(TreeNode root, List<Integer> integers, int i) {
        if (root == null) return;
        if (i == integers.size()) integers.add(root.val);
        addVal(root.right, integers, i + 1);
        addVal(root.left, integers, i + 1);
    }
}