package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.Arrays;

/**
 * Created by Dj on 1/29/17.
 */
public class ConvertSortedArrayToBalancedBST_177_E {
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if(A.length == 0) {
            return null;
        } else if(A.length == 1) {
            return new TreeNode(A[0]);
        }

        TreeNode root = new TreeNode(A[A.length/2]);

        root.left = sortedArrayToBST(Arrays.copyOfRange(A,0,A.length/2));
        root.right = sortedArrayToBST(Arrays.copyOfRange(A,A.length/2+1,A.length));

        return root;
    }
}
