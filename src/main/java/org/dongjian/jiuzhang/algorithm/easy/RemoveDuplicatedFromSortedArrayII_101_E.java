package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatedFromSortedArrayII_101_E {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = 1;

        while (right < nums.length) {
            if (nums[right] == nums[left]) {
                nums[left + 1] = nums[right];
                left++;
                right++;

            }
            while (right < nums.length && nums[right] == nums[left]) {
                right++;
            }

            if (right < nums.length) {
                nums[left + 1] = nums[right];
                left++;
                right++;
            }
        }

        return left + 1;
    }
}
