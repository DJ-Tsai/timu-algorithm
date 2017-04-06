package org.dongjian.jiuzhang.algorithm.medium;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 1/30/17.
 */
public class ValidateBinarySearchTree_95_M {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        if(root.left == null) {
            return isValidBST(root.right) && isGreater(root.right, root.val);
        }

        if(root.right == null) {
            return isValidBST(root.left) && isLess(root.left, root.val);
        }

        if(root.right.val > root.val && root.left.val < root.val) {
            return isValidBST(root.right) && isValidBST(root.left) && isLess(root.left, root.val) && isGreater(root.right, root.val);
        } else {
            return false;
        }
    }

    private boolean isGreater(TreeNode root, int target) {
        if(root == null) {
            return true;
        }

        if(root.val > target) {
            return isGreater(root.right, target) && isGreater(root.left, target);
        } else {
            return false;
        }
    }

    private boolean isLess(TreeNode root, int target) {
        if(root == null) {
            return true;
        }

        if(root.val < target) {
            return isLess(root.right, target) && isLess(root.left, target);
        } else {
            return false;
        }
    }
}
