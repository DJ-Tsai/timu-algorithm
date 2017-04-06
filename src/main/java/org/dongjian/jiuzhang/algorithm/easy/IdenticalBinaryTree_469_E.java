package org.dongjian.jiuzhang.algorithm.easy;


import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 1/29/17.
 */
public class IdenticalBinaryTree_469_E {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null) {
            return true;
        } else if(a == null || b == null) {
            return false;
        }

        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right) && (a.val == b.val);
    }
}
