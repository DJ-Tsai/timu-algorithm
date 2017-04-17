package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * For the given binary tree, return a deep copy of it.
 * <p>
 * Example
 * Given a binary tree:
 * <p>
 *      1
 *    /  \
 *   2    3
 *  / \
 * 4   5
 * return the new binary tree with same structure and same value:
 * <p>
 *      1
 *    /  \
 *   2    3
 *  / \
 * 4   5
 */
public class CloneBinaryTree_375_E {
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = cloneTree(root.left);
        newRoot.right = cloneTree(root.right);

        return newRoot;
    }
}
