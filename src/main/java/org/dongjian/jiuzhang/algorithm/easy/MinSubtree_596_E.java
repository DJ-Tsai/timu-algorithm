package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Given a binary tree, find the subtree with minimum sum. Return the root of the subtree.
 * Given a binary tree:
 * <p>
 *      1
 *    /   \
 *   -5     2
 *  / \   /  \
 * 0   2 -4  -5
 * return the node 1.
 */
public class MinSubtree_596_E {
    TreeNode minNode;
    int minSum = 0;

    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return minNode;
    }

    // find the sum of root node
    private int helper(TreeNode root) {
        if (null == root) {
            return 0;
        }

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        int rootSum = leftSum + rightSum + root.val;

        if (rootSum == 0 || rootSum < minSum) {
            minSum = rootSum;
            minNode = root;
        }

        return rootSum;
    }
}
