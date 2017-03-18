package org.dongjian.jiuzhang.algorithm.easy;

/**
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n) time complexity.
 * e
 * If the target number does not exist in the array, return -1.
 *
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 */
public class FirstPositionOfTarget_14_E {
    public int binarySearch(int[] nums, int target) {
        //write your code
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (nums[mid] >= target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }

        if (nums[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
