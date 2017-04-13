package org.dongjian.jiuzhang.algorithm.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
 * <p>
 * Notice
 * <p>
 * If there are multiple solutions, return any subset is fine.
 * <p>
 * Example
 * Given nums = [1,2,3], return [1,2] or [1,3]
 * <p>
 * Given nums = [1,2,4,8], return [1,2,4,8]
 */
public class LargestDivisibleSubset_603_M {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();

        if (nums == null) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }

        Arrays.sort(nums);

        int[] f = new int[nums.length];
        int maxInd = 0;
        for (int i = 0; i < nums.length; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[j] >= f[i]) {
                    f[i] = f[j] + 1;
                }
            }
            if (f[maxInd] < f[i]) {
                maxInd = i;
            }
        }

        res.add(nums[maxInd]);
        int cur = nums[maxInd];
        int seqCount = f[maxInd] - 1;
        for (int i = maxInd - 1; i >= 0; i--) {
            if (seqCount == 0) {
                return reverse(res);
            }

            if (f[i] == seqCount && cur % nums[i] == 0) {
                res.add(nums[i]);
                cur = nums[i];
                seqCount = f[i] - 1;
            }
        }

        return res;
    }

    private List<Integer> reverse(List<Integer> res) {
        int i = 0;
        int j = res.size() - 1;
        while (i < j) {
            int temp = res.get(i);
            res.set(i, res.get(j));
            res.set(j, temp);
            i++;
            j--;
        }

        return res;
    }
}
