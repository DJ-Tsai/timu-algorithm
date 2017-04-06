package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 1/28/17.
 */
public class MaximunDepthOfBinaryTree_97_E {
    private int depth = 0;
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        helper(root, 1);
        return depth;
    }

    private void helper(final TreeNode root, final int level){
        if(root == null) {
            return;
        }

        depth = Math.max(level, depth);

        helper(root.left, level + 1);
        helper(root.right, level + 1);
    }
}
