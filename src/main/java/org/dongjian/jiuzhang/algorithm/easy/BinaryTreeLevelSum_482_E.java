package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 1/28/17.
 */
public class BinaryTreeLevelSum_482_E {
    int sum;
    /**
     * @param root the root of the binary tree
     * @param level the depth of the target level
     * @return an integer
     */
    public int levelSum(TreeNode root, int level) {
        // Write your code
        levelSumHelper(root, level, 1);
        return sum;
    }

    public void levelSumHelper(TreeNode root, int level, int currentLevel) {
        if (root == null) {
            return;
        }

        if (currentLevel == level) {
            sum += root.val;
            return;
        }

        levelSumHelper(root.left, level, currentLevel + 1);
        levelSumHelper(root.right, level, currentLevel + 1);
    }
}
