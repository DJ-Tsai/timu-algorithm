package org.dongjian.jiuzhang.algorithm.common;

/**
 * Created by Dj on 3/27/17.
 */
public class DoublyListNode {

    int val;
      public DoublyListNode next;
    public DoublyListNode prev;
      public DoublyListNode(int val) {
          this.val = val;
          this.next = this.prev = null;
      }
}
