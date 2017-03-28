package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * If the given node has no in-order successor in the tree, return null.
 * <p>
 * Notice
 * <p>
 * It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)
 * <p>
 * Example
 * Given tree = [2,1] and node = 1:
 * <p>
 *   2
 *  /
 * 1
 * return node 2.
 * <p>
 * Given tree = [2,1,3] and node = 2:
 * <p>
 *   2
 *  / \
 * 1   4
 *    /
 *   3
 * return node 3.
 */
public class InorderSuccessorInBST_448_M {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (null == p) {
            return null;
        }

        if (root.val == p.val) {
            if (root.right == null) {
                return null;
            }

            TreeNode successor = root.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        } else if (root.val > p.val) {
            TreeNode successor = inorderSuccessor(root.left, p);
            return successor == null ? root : successor;
        } else {
            TreeNode successor = inorderSuccessor(root.right, p);
            return successor;
        }
    }
}
