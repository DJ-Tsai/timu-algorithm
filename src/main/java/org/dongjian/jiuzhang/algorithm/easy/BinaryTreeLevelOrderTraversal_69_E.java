package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Dj on 3/19/17.
 */
public class BinaryTreeLevelOrderTraversal_69_E {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList();

        if (null == root) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList();
        // add the current level to queue
        // only root on level 0
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> currentLevel = new ArrayList();

            // CANNOT write queue.size() in for loop condition
            // since if for loop, we keep adding node to the queue
            // the size will keep increasing, so that all node will still be
            // traverse but all in one for loop (which means in one level)
            // we want each for loop only handle one level.
            // so we have to get the constant size before for loop
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.remove();
                currentLevel.add(head.val);
                if (null != head.left) {
                    queue.add(head.left);
                }

                if (null != head.right) {
                    queue.add(head.right);
                }
            }
            results.add(currentLevel);
        }

        return results;

    }
}
