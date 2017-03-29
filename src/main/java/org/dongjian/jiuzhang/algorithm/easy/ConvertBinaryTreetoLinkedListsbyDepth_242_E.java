package org.dongjian.jiuzhang.algorithm.easy;

import org.dongjian.jiuzhang.algorithm.common.ListNode;
import org.dongjian.jiuzhang.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 * <p>
 * Example
 * Given binary tree:
 * <p>
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 * return
 * <p>
 * [
 * 1->null,
 * 2->3->null,
 * 4->null
 * ]
 */
public class ConvertBinaryTreetoLinkedListsbyDepth_242_E {
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> res = new ArrayList<ListNode>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        ListNode dummy = new ListNode(0);
        ListNode pointer;
        while (!queue.isEmpty()) {
            dummy.next = null;
            pointer = dummy;

            // Don't forgot the following line!!!!!!!
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.remove();
                pointer.next = new ListNode(head.val);
                pointer = pointer.next;

                if (head.left != null) {
                    queue.add(head.left);
                }

                if (head.right != null) {
                    queue.add(head.right);
                }
            }

            if (dummy.next != null) {
                res.add(dummy.next);
            }
        }

        return res;
    }
}
