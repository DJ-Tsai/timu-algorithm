package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Created by Dj on 3/10/17.
 */
public class LastPositionOfTarget_458_E {
    public int lastPosition(int[] nums, int target) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[end] == target) {
            return end;
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }
}
