package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dj on 1/28/17.
 */
public class BinaryTreePath_480_E {
    private List<String> result = new ArrayList();

    /**
     * @param root the root of the binary tree
     * @return all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // Write your code here
        helper(root, new ArrayList<Integer>());
        return result;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        list.add(root.val);

        if(root.right == null && root.left == null) {
            result.add(translate(list));
        }

        helper(root.left, list);
        helper(root.right, list);

        list.remove(list.size()-1);
    }


    private String translate(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < list.size() - 1; i++) {
            builder.append(list.get(i)).append("->");
        }
        builder.append(list.get(list.size()-1));
        return builder.toString();
    }
}
