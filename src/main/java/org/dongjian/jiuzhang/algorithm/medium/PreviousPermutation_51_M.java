package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;

/**
 * Given a list of integers, which denote a permutation.
 * <p>
 * Find the previous permutation in ascending order.
 * <p>
 * Notice
 * <p>
 * The list may contains duplicate integers.
 * <p>
 * Example
 * For [1,3,2,3], the previous permutation is [1,2,3,3]
 * <p>
 * For [1,2,3,4], the previous permutation is [4,3,2,1]
 */
public class PreviousPermutation_51_M {
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (nums == null || nums.size() == 0) {
            return res;
        }

        // find first incremental # from end
        int ascIndex = -1;
        for (int i = nums.size() - 2; i >= 0; i--) {
            if (nums.get(i) > nums.get(i + 1)) {
                ascIndex = i;
                break;
            }
        }

        if (ascIndex == -1) {
            reverse(nums, 0);
            return nums;
        }

        // find the least number larger than first deremental #
        int start = ascIndex + 1;
        int end = nums.size() - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) < nums.get(ascIndex)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums.get(end) < nums.get(ascIndex)) {
            swap(nums, end, ascIndex);
        } else {
            swap(nums, start, ascIndex);
        }

        reverse(nums, ascIndex + 1);
        return nums;
    }

    private void reverse(ArrayList<Integer> nums, int startIndex) {
        int start = startIndex;
        int end = nums.size() - 1;

        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

    private void swap(ArrayList<Integer> nums, int i1, int i2) {
        int temp = nums.get(i1);
        nums.set(i1, nums.get(i2));
        nums.set(i2, temp);
    }
}
