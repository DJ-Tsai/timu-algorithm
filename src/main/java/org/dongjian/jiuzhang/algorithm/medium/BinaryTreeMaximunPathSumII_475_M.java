package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Given a binary tree, find the maximum path sum from root.
 * <p>
 * The path may end at any node in the tree and contain at least one node in it.
 * <p>
 * Example
 * Given the below binary tree:
 * <p>
 *   1
 *  / \
 * 2   3
 * return 4. (1->3)
 */
public class BinaryTreeMaximunPathSumII_475_M {
    public int maxPathSum2(TreeNode root) {

        if (null == root) {
            return 0;
        }

        int leftMax = maxPathSum2(root.left);
        int rightMax = maxPathSum2(root.right);

        return Math.max(Math.max(leftMax, rightMax) + root.val, root.val);
    }
}
