package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 1/29/17.
 */
public class InsertNodeInBST_85_E {
    /**
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(node == null) {
            return root;
        }

        if(root == null) {
            return node;
        }

        if(node.val < root.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }

        return root;
    }
}
