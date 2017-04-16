package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * Example
 * Given input array A = [1,1,2],
 * <p>
 * Your function should return length = 2, and A is now [1,2].
 */
public class RemoveDuplicatedFromSortedArray_101_E {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p1 = 0, p2 = 0;

        while (p2 < nums.length) {
            while (p2 < nums.length && nums[p2] == nums[p1]) {
                p2++;
            }

            if (p2 < nums.length) {
                nums[p1 + 1] = nums[p2];
                p1++;
                p2++;
            }
        }

        return p1 + 1;
    }
}
