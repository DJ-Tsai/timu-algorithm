package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of integers, find two numbers that their difference equals to a target value.
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are NOT zero-based.
 * <p>
 * Notice
 * <p>
 * It's guaranteed there is only one available solution
 * <p>
 * Example
 * Given nums = [2, 7, 15, 24], target = 5
 * return [1, 2] (7 - 2 = 5)
 */
public class TowSum_DifferenceEqualsToTarget_610_M {
    public int[] twoSum7(int[] nums, int target) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return null;
        }

        target = Math.abs(target);

        // twoSum 问题 如果要返回index, 如用two pointer方法解决时,要用到sorting, 就需要在sorting时记录index的信息,不然sorting后index的信息就丢失了
        Pair[] res = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = new Pair(nums[i], i);
        }

        // sort
        Arrays.sort(res, new Comparator<Pair>() {

            public int compare(Pair o1, Pair o2) {
                return 0;
            }
        });

        int i = 0;
        int j = i + 1;

        while (j < res.length) {
            if (res[j].val - res[i].val == target) {
                return new int[]{Math.min(res[i].ind + 1, res[j].ind + 1), Math.max(res[i].ind + 1, res[j].ind + 1)};
            } else if (res[j].val - res[i].val < target) {
                j++;
            } else {
                i++;
                if (i == j) {
                    j++;
                }
            }
        }

        return null;

    }

    private class Pair {
        int val;
        int ind;

        Pair(int val, int ind) {
            this.val = val;
            this.ind = ind;
        }
    }
}
