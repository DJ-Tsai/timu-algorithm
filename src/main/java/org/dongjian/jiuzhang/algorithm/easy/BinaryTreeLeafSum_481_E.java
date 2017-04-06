package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 1/28/17.
 */
public class BinaryTreeLeafSum_481_E {
    int sum = 0;
    /**
     * @param root the root of the binary tree
     * @return an integer
     */
    public int leafSum(TreeNode root) {
        // Write your code
        leafSumHelper(root);
        return sum;
    }

    private void leafSumHelper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum += root.val;
        }

        leafSumHelper(root.left);
        leafSumHelper(root.right);
    }
}
