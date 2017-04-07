package org.dongjian.jiuzhang.algorithm.medium;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an integer array, find the top k largest numbers in it.
 * <p>
 * Example
 * Given [3,10,1000,-99,4,100] and k = 3.
 * Return [1000, 100, 10].
 */
public class TopKLargestNumber_544_M {
    public int[] topk(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<Integer>();

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);

            if (queue.size() > k) {
                queue.remove();
            }
        }

        int[] res = new int[k];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = queue.remove();
        }

        return res;
    }
}
