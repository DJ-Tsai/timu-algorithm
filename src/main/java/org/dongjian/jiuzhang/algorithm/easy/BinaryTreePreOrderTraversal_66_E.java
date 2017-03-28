package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreOrderTraversal_66_E {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        preOrderTraversal(root, res);

        return res;
    }

    private void preOrderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (null == root) {
            return;
        }

        res.add(root.val);
        preOrderTraversal(root.left, res);
        preOrderTraversal(root.right, res);
    }
}
