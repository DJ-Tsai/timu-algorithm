package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Notice
 * <p>
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example
 * For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:
 * <p>
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum_57_M {
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i == 0 || numbers[i] != numbers[i - 1]) {
                int start = i + 1;
                int end = numbers.length - 1;
                int target = 0 - numbers[i];

                while (start < end) {
                    int num1 = numbers[start];
                    int num2 = numbers[end];

                    if (numbers[start] + numbers[end] < target) {
                        start++;
                        while (numbers[start] == num1 && start < end) {
                            start++;
                        }
                    } else if (numbers[start] + numbers[end] > target) {
                        end--;
                        while (numbers[end] == num2 && start < end) {
                            end--;
                        }
                    } else {
                        ArrayList<Integer> sub = new ArrayList<Integer>(3);
                        sub.add(numbers[i]);
                        sub.add(num1);
                        sub.add(num2);
                        res.add(sub);
                        while (numbers[start] == num1 && start < end) {
                            start++;
                        }
                        while (numbers[end] == num2 && start < end) {
                            end--;
                        }
                    }
                }
            }
        }

        return res;
    }
}
