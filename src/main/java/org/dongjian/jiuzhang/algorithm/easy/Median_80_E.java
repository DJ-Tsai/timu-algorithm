package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a unsorted array with integers, find the median of it.
 * <p>
 * A median is the middle number of the array after it is sorted.
 * <p>
 * If there are even numbers in the array, return the N/2-th number after sorted.
 * <p>
 * Example
 * Given [4, 5, 1, 2, 3], return 3.
 * <p>
 * Given [7, 9, 4, 5], return 5.
 * Challenge
 * O(n) time.
 */
public class Median_80_E {
    public int median(int[] nums) {
        int k;
        if (nums.length % 2 == 0) {
            k = nums.length / 2;
        } else {
            k = nums.length / 2 + 1;
        }

        return findKthLargerst(nums, 0, nums.length - 1, k);
    }

    private int findKthLargerst(int[] nums, int start, int end, int k) {

        if (start == end) {
            return nums[start];
        }

        int left = start;
        int right = end;
        int pivot = nums[left + (right - left) / 2];

        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        if (right - start + 1 < k && k < left - start + 1) {
            return nums[right + 1];
        } else if (right - start + 1 >= k) {
            return findKthLargerst(nums, start, right, k);
        } else {
            return findKthLargerst(nums, left, end, k - (left - start));
        }
    }
}
