package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;

/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 * For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 *
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 *
 * requirement: In-place, O(1) extra space and O(n) time.
 */
public class RecoverRotatedSortedArray_39_E {
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        int maxIndex = nums.size() - 1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                maxIndex = i;
            }
        }

        if (maxIndex == nums.size() - 1) {
            return;
        }

        reverse(nums, 0, maxIndex);
        reverse(nums, maxIndex + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);

    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            Integer temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
}
