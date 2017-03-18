package org.dongjian.jiuzhang.algorithm.easy;

import com.faith.dj.jiuzhang.java.fundamental.common.TreeNode;

/**
 * Created by Dj on 1/28/17.
 */
public class MinimunDepthOfBinaryTree_155_E {
    // if the tree is null, the minDepth is 0
    private int minDepth = 0;

    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        helper(root, 1);
        return minDepth;
    }

    private void helper(TreeNode root, int level) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            minDepth = minDepth == 0 ? level : Math.min(level, minDepth);
        }

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
