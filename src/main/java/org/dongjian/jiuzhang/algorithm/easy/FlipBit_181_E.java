package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Determine the number of bits required to flip if you want to convert integer n to integer m.
 * <p>
 * Notice
 * <p>
 * Both n and m are 32-bit integers.
 * <p>
 * Example
 * Given n = 31 (11111), m = 14 (01110), return 2.
 */
public class FlipBit_181_E {
    public static int bitSwapRequired(int a, int b) {
        int c = a ^ b;

        int count = 0;
        for (int i = c; i != 0; i = i >>> 1) {
            if ((i & 1) == 1) {
                count++;
            }
        }

        return count;
    }
}
