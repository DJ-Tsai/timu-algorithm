package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given a list of integers, which denote a permutation.
 * <p>
 * Find the next permutation in ascending order.
 * <p>
 * Notice
 * <p>
 * The list may contains duplicate integers.
 * <p>
 * Example
 * For [1,3,2,3], the next permutation is [1,3,3,2]
 * <p>
 * For [4,3,2,1], the next permutation is [1,2,3,4]
 */
public class NextPermutation_52_M {
    public int[] nextPermutation(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }


        // find index of first decremental number
        int decIndex = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                decIndex = i;
                break;
            }
        }

        // all increment
        if (decIndex == -1) {
            reverse(nums, 0);
            return nums;
        }

        // find the least number larger than the decremental number
        int start = decIndex + 1;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[decIndex]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int index;
        if (nums[end] > nums[decIndex]) {
            swap(nums, decIndex, end);
        } else {
            swap(nums, decIndex, start);

        }

        reverse(nums, decIndex + 1);
        return nums;

    }

    private void swap(int[] nums, int ind1, int ind2) {
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }

    private void reverse(int[] nums, int startIndex) {
        int start = startIndex;
        int end = nums.length - 1;

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
