package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Count how many 1 in binary representation of a 32-bit integer.
 * <p>
 * Example
 * Given 32, return 1
 * <p>
 * Given 5, return 2
 * <p>
 * Given 1023, return 9
 * <p>
 * Challenge
 * If the integer is n bits with m 1 bits. Can you do it in O(m) time?
 */
public class Count1InBinary_365_E {
    /**
     * Method one: O(n)
     * @param num
     * @return
     */
//    public int countOnes(int num) {
//        int count = 0;
//
//        while (num != 0) {
//            if ((num & 1) == 1) {
//                count++;
//            }
//            num = num >>> 1;
//        }
//
//        return count;
//    }


    /**
     * Method two: O(m)
     * @param num
     * @return
     */
    public int countOnes(int num) {
        int count = 0;

        while (num != 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
    }
}
