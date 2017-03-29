package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 * The path could be start and end at any node in the tree
 * <p>
 * Example
 *     1
 *    / \
 *   2   0
 *  /
 * 3
 * Return 4 // 0-1-2-3-4
 */
public class BinaryTreeLongestConsecutiveSequenceII_614_M {
    public int longestConsecutive2(TreeNode root) {
        return helper(root).maxLen;


    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        ResultType current = new ResultType(1, 1, 1);

        // determine max consecutive for current node
        if (root.left != null && root.left.val + 1 == root.val) {
            current.btotInc = left.btotInc + 1;
        }

        if (root.right != null && root.right.val + 1 == root.val) {
            current.btotInc = Math.max(current.btotInc, right.btotInc + 1);
        }

        if (root.left != null && root.left.val - 1 == root.val) {
            current.btotDec = left.btotDec + 1;
        }

        if (root.right != null && root.right.val - 1 == root.val) {
            current.btotDec = Math.max(current.btotDec, right.btotDec + 1);
        }

        current.maxLen = Math.max(Math.max(left.maxLen, right.maxLen), current.btotDec + current.btotInc - 1);
        // System.out.println(current.btotInc + " " + current.btotDec);

        return current;
    }

    class ResultType {
        int maxLen;
        int btotInc;
        int btotDec;

        ResultType(int maxLen, int inc, int dec) {
            this.maxLen = maxLen;
            this.btotInc = inc;
            this.btotDec = dec;
        }
    }
}
