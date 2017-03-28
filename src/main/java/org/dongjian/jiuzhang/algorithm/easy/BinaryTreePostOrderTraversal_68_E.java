package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostOrderTraversal_68_E {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        postOrderTraversal(root, res);

        return res;
    }

    private void postOrderTraversal(TreeNode root, List<Integer> res) {
        if (null == root) {
            return;
        }

        postOrderTraversal(root.left, res);
        postOrderTraversal(root.right, res);
        res.add(root.val);
    }
}
