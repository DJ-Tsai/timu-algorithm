package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * <p>
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 * <p>
 * For example,
 * <p>
 * 1
 *  \
 *   3
 *  / \
 * 2   4
 *      \
 *       5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 * <p>
 *  2
 *   \
 *    3
 *   /
 *  2
 * /
 * 1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class BinaryTreeLongestConsecutiveSequence_595_E {
    int maxCount = 0;

    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return maxCount;
    }

    private ResultType helper(TreeNode root) {
        if (null == root) {
            return new ResultType(Integer.MIN_VALUE, 0);
        }

        if (null == root.left && null == root.right) {
            return new ResultType(root.val, 1);
        }

        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType rootResult;
        if (root.val == leftResult.val - 1 || root.val == rightResult.val - 1) {
            rootResult = new ResultType(root.val, Math.max(leftResult.count, rightResult.count) + 1);
        } else {
            rootResult = new ResultType(root.val, 1);
        }

        if (maxCount == 0 || maxCount < rootResult.count) {
            maxCount = rootResult.count;
        }

        return rootResult;
    }

    private class ResultType {
        int val;
        int count;

        private ResultType(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
}
