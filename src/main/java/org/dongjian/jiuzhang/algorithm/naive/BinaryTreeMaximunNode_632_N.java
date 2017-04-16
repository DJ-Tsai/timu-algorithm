package org.dongjian.jiuzhang.algorithm.naive;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Find the maximum node in a binary tree, return the node.
 * <p>
 * Example
 * Given a binary tree:
 * <p>
 * 1
 * /   \
 * -5     2
 * / \   /  \
 * 0   3 -4  -5
 * return the node with value 3.
 */
public class BinaryTreeMaximunNode_632_N {
    public TreeNode maxNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode leftMax = maxNode(root.left);
        TreeNode rightMax = maxNode(root.right);

        TreeNode max = root;
        if (leftMax != null && leftMax.val > max.val) {
            max = leftMax;
        }

        if (rightMax != null && rightMax.val > max.val) {
            max = rightMax;
        }

        return max;
    }
}
