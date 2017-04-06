package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 * <p>
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
 *
 * Challenge: Do it in-place without any extra memory.
 */
public class FlattenBinaryTreeToLinkedList_453_E {
    public void flatten(TreeNode root) {
        helper(root);
    }

    private ResultType helper(TreeNode root) {
        if (null == root) {
            return new ResultType(null, null);
        }

        ResultType leftFlatten = helper(root.left);
        ResultType rightFlatten = helper(root.right);

        if (null == leftFlatten.start) {
            if (null == rightFlatten.start) {
                return new ResultType(root, root);
            } else {
                return new ResultType(root, rightFlatten.end);
            }
        } else {
            if (null == rightFlatten.start) {
                root.right = leftFlatten.start;
                root.left = null;
                return new ResultType(root, leftFlatten.end);
            } else {
                leftFlatten.end.right = rightFlatten.start;
                root.right = leftFlatten.start;
                root.left = null;
                return new ResultType(root, rightFlatten.end);
            }

        }
    }

    private class ResultType {
        TreeNode start, end;

        private ResultType(TreeNode start, TreeNode end) {
            this.start = start;
            this.end = end;
        }
    }
}
