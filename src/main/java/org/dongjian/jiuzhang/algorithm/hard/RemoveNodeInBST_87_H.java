package org.dongjian.jiuzhang.algorithm.hard;

import com.faith.dj.jiuzhang.java.fundamental.common.TreeNode;

/**
 * Created by Dj on 1/31/17.
 */
public class RemoveNodeInBST_87_H {
    /**
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if (root == null) {
            return null;
        }

        if (root.val == value) {
            if (root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                TreeNode temp = findEndRightNode(root.left);
                temp.right = root.right;
                root = root.left;
            }
        } else if (root.val < value) {
            root.right = removeNode(root.right, value);
        } else {
            root.left = removeNode(root.left, value);
        }
        return root;
    }

    private TreeNode findEndRightNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root = root.right;
        }

        return root;
    }
}
