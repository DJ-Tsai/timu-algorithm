package org.dongjian.jiuzhang.algorithm.easy;

import com.faith.dj.jiuzhang.java.fundamental.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dj on 1/28/17.
 */
public class BinaryTreePathSum_376_E {
    List<List<Integer>> result = new ArrayList();
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        helper(root, target, new ArrayList<Integer>(), 0);
        return result;
    }

    private void helper(TreeNode node, int target, List<Integer> list, int sum) {
        if(node == null) {
            return;
        }

        list.add(node.val);
        sum += node.val;

        if(node.right == null && node.left == null && sum == target) {
            result.add(new ArrayList(list));
        }

        helper(node.left, target, list, sum);
        helper(node.right, target, list, sum);

        list.remove(list.size() - 1);
    }
}
