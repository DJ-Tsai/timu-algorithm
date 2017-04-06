package org.dongjian.jiuzhang.algorithm.medium;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * <p>
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 */
public class LowestCommonAncester_88_M {
    TreeNode result = null;

    /**
     * @param root: The root of the binary search tree.
     * @param A     and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        helper(root, A, B);
        return result;

    }

    private boolean helper(TreeNode root, TreeNode A, TreeNode B) {
        if (null == root) {
            return false;
        }

        boolean leftResult = helper(root.left, A, B);
        boolean rightResult = helper(root.right, A, B);

        if (null != result) {
            return true;
        }

        if (root == A && root == B) {
            result = root;
            return true;
        }

        if (true == leftResult && true == rightResult) {
            result = root;
            return true;
        }

        if (true == leftResult || true == rightResult) {
            if (root == A || root == B) {
                result = root;
                return true;
            } else {
                return true;
            }
        }

        return (root == A || root == B);
    }
}
