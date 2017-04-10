package org.dongjian.jiuzhang.algorithm.medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * Ugly number is a number that only have factors 2, 3 and 5.
 * <p>
 * Design an algorithm to find the nth ugly number. The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 * <p>
 * Notice
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * Example
 * If n=9, return 10.
 * <p>
 * Challenge
 * O(n log n) or O(n) time.
 */
public class UglyNumberII_4_M {
    public int nthUglyNumber(int n) {
        Queue<Long> queue = new PriorityQueue();
        Set<Long> inQ = new HashSet();
        long[] magic = new long[3];

        queue.add(1L);
        inQ.add(1L);

        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            long head = queue.remove();
            if (count == n) {
                return (int) head;
            }
            magic[0] = head * 2;
            magic[1] = head * 3;
            magic[2] = head * 5;

            for (int i = 0; i < magic.length; i++) {
                if (inQ.contains(magic[i])) {
                    continue;
                }

                queue.add(magic[i]);
                inQ.add(magic[i]);
            }
        }

        return -1;
    }
}
