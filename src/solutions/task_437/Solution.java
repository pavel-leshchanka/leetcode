package solutions.task_437;

import java.util.ArrayList;
import java.util.List;

/**
 * 437. Path Sum III
 * Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values
 * along the path equals targetSum.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (i.e., traveling only from parent nodes to child nodes).
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

    public static int count = 0;

    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        if (root == null) return 0;
        getSums(root, targetSum);
        return count;
    }

    public List<Long> getSums(TreeNode node, int target) {
        if (node == null) return List.of();
        List<Long> longs = new ArrayList<>();
        longs.addAll(getSums(node.left, target));
        longs.addAll(getSums(node.right, target));
        longs.replaceAll(a -> a + node.val);
        longs.add((long) node.val);
        for (Long integer : longs) {
            if (integer == target) count++;
        }
        return longs;
    }
}