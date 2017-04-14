package org.dongjian.jiuzhang.algorithm.easy;

import java.util.ArrayList;

/**
 * Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.
 * <p>
 * Notice
 * <p>
 * You may assume that the array is non-empty and the majority number always exist in the array.
 * <p>
 * Example
 * Given [1, 1, 1, 1, 2, 2, 2], return 1
 * <p>
 * Challenge
 * O(n) time and O(1) extra space
 */
public class MajorityNumber_46_E {
    public int majorityNumber(ArrayList<Integer> nums) {
        int cadidate = -1;
        int count = 0;

        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                cadidate = nums.get(i);
                count++;
            } else if (cadidate == nums.get(i)) {
                count++;
            } else {
                count--;
            }
        }

        return cadidate;
    }
}
