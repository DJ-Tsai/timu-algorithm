package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal_67_E {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        inOrderTraversal(root, res);

        return res;
    }

    private void inOrderTraversal(TreeNode root, ArrayList<Integer> res) {
        if (null == root) {
            return;
        }

        inOrderTraversal(root.left, res);
        res.add(root.val);
        inOrderTraversal(root.right, res);
    }
}
