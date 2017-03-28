package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.DoublyListNode;
import org.dongjian.jiuzhang.algorithm.common.TreeNode;

/**
 * Created by Dj on 3/27/17.
 */
public class ConvertBinarySearchTreetoDoublyLinkedList_378_M {
    public DoublyListNode bstToDoublyList(TreeNode root) {
        if (null == root) {
            return null;
        }
        DoublyListNode[] res = build(root);
        return res[0];
    }

    // return the rightest node
    private DoublyListNode[] build(TreeNode root) {
        if (null == root) {
            return null;
        }


        // to this line, I can garantee that root is not null
        // both left and right could be null
        // need check for both of them
        DoublyListNode[] left = build(root.left);
        DoublyListNode[] right = build(root.right);
        DoublyListNode newRoot = new DoublyListNode(root.val);
        DoublyListNode newLeft, newRight;

        if (left == null) {
            newLeft = newRoot;
        } else {
            newRoot.prev = left[1];
            left[1].next = newRoot;
            newLeft = left[0];
        }

        if (right == null) {
            newRight = newRoot;
        } else {
            newRoot.next = right[0];
            right[0].prev = newRoot;
            newRight = right[1];
        }

        // System.out.println(newLeft.val +" " + newRight.val);
        return new DoublyListNode[]{newLeft, newRight};
    }
}
