package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Partition an integers array into odd number first and even number second.
 * <p>
 * Example
 * Given [1, 2, 3, 4], return [1, 3, 2, 4]
 * <p>
 * Challenge
 * Do it in-place.
 */
public class PartitionArrayByOddAndEven_373_E {
    public void partitionArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            while (left <= right && nums[left] % 2 == 1) {
                left++;
            }

            while (left <= right && nums[right] % 2 == 0) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
}
