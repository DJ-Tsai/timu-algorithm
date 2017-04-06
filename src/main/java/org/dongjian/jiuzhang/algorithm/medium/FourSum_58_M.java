package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * <p>
 * Find all unique quadruplets in the array which gives the sum of target.
 * <p>
 * Notice
 * <p>
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * <p>
 * Example
 * Given array S = {1 0 -1 0 -2 2}, and target = 0. A solution set is:
 * <p>
 * (-1, 0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2, 0, 0, 2)
 */
public class FourSum_58_M {
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        if (numbers == null || numbers.length < 4) {
            return res;
        }

        Arrays.sort(numbers);

        for (int i1 = 0; i1 < numbers.length - 3; i1++) {
            if (i1 != 0 && numbers[i1] == numbers[i1 - 1]) {
                continue;
            }
            int target1 = target - numbers[i1];

            for (int i2 = i1 + 1; i2 < numbers.length - 2; i2++) {
                if (i2 != i1 + 1 && numbers[i2] == numbers[i2 - 1]) {
                    continue;
                }
                int target2 = target1 - numbers[i2];
                int left = i2 + 1;
                int right = numbers.length - 1;

                while (left < right) {
                    if (numbers[left] + numbers[right] == target2) {
                        ArrayList<Integer> sub = new ArrayList<Integer>();
                        sub.add(numbers[i1]);
                        sub.add(numbers[i2]);
                        sub.add(numbers[left]);
                        sub.add(numbers[right]);
                        res.add(sub);
                        left++;
                        while (numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                        right--;
                        while (numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    } else if (numbers[left] + numbers[right] < target2) {
                        left++;
                        while (numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                    } else {
                        right--;
                        while (numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }

        return res;
    }
}
