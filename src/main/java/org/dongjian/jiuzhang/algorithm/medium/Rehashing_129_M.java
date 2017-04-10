package org.dongjian.jiuzhang.algorithm.medium;

import org.dongjian.jiuzhang.algorithm.common.ListNode;

/**
 * The size of the hash table is not determinate at the very beginning. If the total size of keys is too large (e.g. size >= capacity / 10), we should double the size of the hash table and rehash every keys. Say you have a hash table looks like below:
 * <p>
 * size=3, capacity=4
 * <p>
 * [null, 21, 14, null]
 * ↓    ↓
 * 9   null
 * ↓
 * null
 * The hash function is:
 * <p>
 * int hashcode(int key, int capacity) {
 * return key % capacity;
 * }
 * here we have three numbers, 9, 14 and 21, where 21 and 9 share the same position as they all have the same hashcode 1 (21 % 4 = 9 % 4 = 1). We store them in the hash table by linked list.
 * <p>
 * rehashing this hash table, double the capacity, you will get:
 * <p>
 * size=3, capacity=8
 * <p>
 * index:   0    1    2    3     4    5    6   7
 * hash : [null, 9, null, null, null, 21, 14, null]
 * Given the original hash table, return the new hash table after rehashing .
 * <p>
 * Notice
 * <p>
 * For negative integer in hash table, the position can be calculated as follow:
 * <p>
 * C++/Java: if you directly calculate -4 % 3 you will get -1. You can use function: a % b = (a % b + b) % b to make it is a non negative integer.
 * Python: you can directly use -1 % 3, you will get 2 automatically.
 * <p>
 * Example
 * Given [null, 21->9->null, 14->null, null],
 * <p>
 * return [null, 9->null, null, null, null, 21->null, 14->null
 */
public class Rehashing_129_M {
    public ListNode[] rehashing(ListNode[] hashTable) {

        int len = hashTable.length * 2;
        ListNode[] res = new ListNode[len];
        ListNode[] track = new ListNode[len];

        for (int i = 0; i < hashTable.length; i++) {

            ListNode head = hashTable[i];

            while (head != null) {

                int index = mod(head.val, len);
                if (res[index] == null) {
                    res[index] = new ListNode(head.val);
                    track[index] = res[index];
                } else {
                    track[index].next = new ListNode(head.val);
                    track[index] = track[index].next;
                }
                head = head.next;
            }
        }

        return res;
    }

    private int mod(int a, int b) {
        return (a % b + b) % b;
    }
}
