package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class JumpGameII_117_M {
    public int jump(int[] A) {
        int[] jumpNum = new int[A.length];

        for (int i = 0; i < jumpNum.length; i++) {
            jumpNum[i] = Integer.MAX_VALUE;
        }

        // init
        jumpNum[0] = 0;

        // DP
        for (int i = 0; i < jumpNum.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] >= i - j && jumpNum[j] != Integer.MAX_VALUE) {
                    jumpNum[i] = Math.min(jumpNum[i], jumpNum[j] + 1);
                }
            }
        }

        return jumpNum[A.length - 1];
    }
}
