package org.dongjian.jiuzhang.algorithm.medium;

import java.util.Arrays;

/**
 * Given an array of integers, how many three numbers can be found in the array, so that we can build an triangle whose three edges length is the three numbers that we find?
 * <p>
 * Example
 * Given array S = [3,4,6,7], return 3. They are:
 * <p>
 * [3,4,6]
 * [3,6,7]
 * [4,6,7]
 * Given array S = [4,4,4,4], return 4. They are:
 * <p>
 * [4(1),4(2),4(3)]
 * [4(1),4(2),4(4)]
 * [4(1),4(3),4(4)]
 * [4(2),4(3),4(4)]
 */
public class TriangelCount_382_M {
    public int triangleCount(int S[]) {
        int count = 0;

        if (S == null || S.length < 3) {
            return count;
        }

        Arrays.sort(S);

        for (int i = 0; i < S.length - 2; i++) {
            int left = i + 1;
            int right = left + 1;

            while (right < S.length) {
                // 最小两边 > 第三边, 所以 所有在left右边的边都可以
                if (S[right] - S[left] < S[i]) {
                    count = count + right - left;
                    right++;
                } else {
                    left++;
                    if (left == right) {
                        right++;
                    }
                }
            }
        }

        return count;
    }
}
