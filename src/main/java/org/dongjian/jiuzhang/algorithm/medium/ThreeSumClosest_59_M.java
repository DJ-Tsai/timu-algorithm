package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
 * <p>
 * Notice
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example
 * For example, given array S = [-1 2 1 -4], and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * <p>
 * O(n^2) time, O(1) extra space
 */
public class ThreeSumClosest_59_M {
    public int threeSumClosest(int[] numbers, int target) {
        int diff = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            int left = i + 1;
            int right = numbers.length - 1;
            int aim = target - numbers[i];

            while (left < right) {
                if (numbers[left] + numbers[right] > aim) {
                    if (numbers[left] + numbers[right] + numbers[i] - target < diff) {
                        diff = numbers[left] + numbers[right] + numbers[i] - target;
                        sum = numbers[left] + numbers[right] + numbers[i];
                    }
                    right--;
                } else {
                    if (target - numbers[left] - numbers[right] - numbers[i] < diff) {
                        diff = target - numbers[left] - numbers[right] - numbers[i];
                        sum = numbers[left] + numbers[right] + numbers[i];
                    }
                    left++;
                }
            }
        }

        return sum;
    }
}
