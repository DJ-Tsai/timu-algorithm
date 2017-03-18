package org.dongjian.jiuzhang.algorithm.easy;

import com.faith.dj.jiuzhang.java.fundamental.common.TreeNode;

/**
 * Created by Dj on 1/30/17.
 */
public class TweakedIdenticalBinaryTree_470_E {
    /**
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null) {
            return true;
        }

        if(a == null || b == null) {
            return false;
        }

        if(a.val != b.val) {
            return false;
        }

        return isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left) ||
                isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right);
    }
}
