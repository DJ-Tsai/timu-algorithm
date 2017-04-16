package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Example
 * For n=4, return true;
 * <p>
 * For n=5, return false;
 * <p>
 * Challenge
 * O(1) time
 */
public class CheckPowerOf2_142_E {
    public boolean checkPowerOf2(int n) {
        if (n <= 0) {
            return false;
        }

        return (n & (n - 1)) == 0;
    }
}
