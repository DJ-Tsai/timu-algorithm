package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Your are given a binary tree in which each node contains a value. Design an algorithm to get all paths which sum to a given value. The path does not need to start or end at the root or a leaf, but it must go in a straight line down.
 * <p>
 * Example
 * Given a binary tree:
 * <p>
 *       1
 *     / \
 *   2   3
 *  /   /
 * 4   2
 * for target = 6, return
 * <p>
 * [
 * [2, 4],
 * [1, 3, 2]
 * ]
 */
public class BinaryTreePathSumII_246_E {
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList();

        if (null == root) {
            return res;
        }


        helper(root, target, 0, new ArrayList<Integer>(), res);

        return res;
    }

    private void helper(TreeNode root, int target, int sum, List<Integer> subset, List<List<Integer>> res) {
        if (null == root) {
            return;
        }

        subset.add(root.val);
        sum = sum + root.val;

        if (sum >= target) {
            int temp = 0;
            for (int i = subset.size() - 1; i >= 0; i--) {
                temp = temp + subset.get(i);
                if (temp == target) {
                    res.add(new ArrayList(subset.subList(i, subset.size())));
                }
            }
        }

        helper(root.left, target, sum, subset, res);
        helper(root.right, target, sum, subset, res);

        subset.remove(subset.size() - 1);

    }
}
