package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Write a program to check whether a given number is an ugly number`.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Notice
 * <p>
 * Note that 1 is typically treated as an ugly number.
 * <p>
 * xample
 * Given num = 8 return true
 * Given num = 14 return false
 */
public class UglyNumber_517_E {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }
        int[] prime = {2, 3, 5};
        for (int i = 0; i < prime.length; i++) {
            while (num % prime[i] == 0) {
                num = num / prime[i];
            }
        }

        if (num > 1) {
            return false;
        }

        return true;
    }
}
