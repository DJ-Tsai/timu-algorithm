package org.dongjian.jiuzhang.algorithm.medium;

import com.faith.dj.jiuzhang.java.fundamental.common.TreeNode;

/**
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 * <p>
 * For the following binary tree:
 * <p>
 *     4
 *    / \
 *   3  7
 *  / \
 * 5  6
 * LCA(3, 5) = 4
 * <p>
 * LCA(5, 6) = 7
 * <p>
 * LCA(6, 7) = 7
 */
public class LowestCommonAncesterIII_578_M {
    TreeNode ancester = null;

    /**
     * @param root The root of the binary tree.
     * @param A    and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        helper(root, A, B);
        return ancester;
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (null == root) {
            return new ResultType(false);
        }

        ResultType leftResult = helper(root.left, A, B);
        ResultType rightResult = helper(root.right, A, B);

        if (null != ancester) {
            return new ResultType(true);
        }

        // Corner case root == A == B
        if (root == A && root == B) {
            ancester = root;
            return new ResultType(true);
        }

        if (leftResult.found && rightResult.found) {
            ancester = root;
            return new ResultType(true);
        }

        if (root == A || root == B) {
            if (leftResult.found || rightResult.found) {
                ancester = root;
            }
            return new ResultType(true);
        }

        // if root is not A or B, but leftResult or rightResult has one, also return true
        return new ResultType(leftResult.found || rightResult.found);
    }

    private class ResultType {
        boolean found;

        private ResultType(boolean found) {
            this.found = found;
        }
    }
}
