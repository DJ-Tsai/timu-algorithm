package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 * <p>
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 * <p>
 * Notice
 * <p>
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 * <p>
 * If all elements in nums are smaller than k, then return nums.length
 * <p>
 * If nums = [3,2,2,1] and k=2, a valid answer is 1.
 * <p>
 * Challenge
 * Can you partition the array in-place and in O(n)?
 */
public class PatitionArray_31_M {
    public int partitionArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            while (i <= j && nums[i] < k) {
                i++;
            }

            while (i <= j && nums[j] >= k) {
                j--;
            }

            if (i <= j) {
                swap(nums, i++, j--);
            }
        }

        return i;


    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
