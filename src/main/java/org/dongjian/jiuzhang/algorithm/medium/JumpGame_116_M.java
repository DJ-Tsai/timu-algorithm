package org.dongjian.jiuzhang.algorithm.medium;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * Notice
 * <p>
 * This problem have two method which is Greedy and Dynamic Programming.
 * <p>
 * The time complexity of Greedy method is O(n).
 * <p>
 * The time complexity of Dynamic Programming method is O(n^2).
 * <p>
 * We manually set the small data set to allow you pass the test in both ways. This is just to let you learn how to use this problem in dynamic programming ways. If you finish it in dynamic programming ways, you can try greedy method to make it accept again.
 * <p>
 * Example
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class JumpGame_116_M {
    public boolean canJump(int[] A) {
        boolean[] canReach = new boolean[A.length];

        // init
        canReach[0] = true;

        // DP
        for (int i = 0; i < canReach.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] >= i - j && canReach[j]) {
                    canReach[i] = true;
                    break;
                }
            }
        }

        return canReach[A.length - 1];
    }
}
