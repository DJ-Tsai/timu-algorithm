package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 1/29/17.
 */
public class BalancedBinaryTree_93_E {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(heightOf(root.left)-heightOf(root.right)) <= 1;

    }

    private int heightOf(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return Math.max(heightOf(root.left),heightOf(root.right)) + 1;
    }
}
