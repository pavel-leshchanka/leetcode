package solutions.task_1161;

import java.util.HashMap;
import java.util.Map;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
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

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        add(root, integerIntegerHashMap, 1);
        long maxSum = Integer.MIN_VALUE;
        int level = 0;
        for (Integer i : integerIntegerHashMap.keySet()) {
            if (integerIntegerHashMap.get(i) > maxSum) {
                level = i;
                maxSum = integerIntegerHashMap.get(i);
            }
        }
        return level;
    }

    public void add(TreeNode node, Map<Integer, Integer> map, int level) {
        if (node == null) return;
        map.put(level, map.getOrDefault(level, 0) + node.val);
        add(node.left, map, ++level);
        add(node.right, map, level);
    }
}