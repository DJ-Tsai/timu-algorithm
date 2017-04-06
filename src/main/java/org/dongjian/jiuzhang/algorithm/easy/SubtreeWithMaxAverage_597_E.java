package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Given a binary tree, find the subtree with maximum average. Return the root of the subtree.
 * <p>
 * Given a binary tree:
 * <p>
 *        1
 *      /   \
 *    -5     11
 *   / \   /  \
 * 1   2 4    -2
 * return the node 11.
 */
public class SubtreeWithMaxAverage_597_E {
    ResultType maxResult;
    TreeNode maxNode;

    /**
     * @param root the roobit of binary tree
     * @return the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return maxNode;
    }

    private ResultType helper(TreeNode root) {
        if (null == root) {
            return new ResultType(0, 0);
        }

        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        ResultType rootResult = new ResultType(leftResult.sum + rightResult.sum + root.val, leftResult.size + rightResult.size + 1);

        if (null == maxResult || rootResult.sum * maxResult.size > maxResult.sum * rootResult.size) {
            maxResult = rootResult;
            maxNode = root;
        }
        return rootResult;
    }

    private class ResultType {
        int sum, size;

        private ResultType(int sum, int size) {
            this.sum = sum;
            this.size = size;
        }
    }
}
