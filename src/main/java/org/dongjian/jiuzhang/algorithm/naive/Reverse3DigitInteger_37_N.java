package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/9/17.
 */
public class Reverse3DigitInteger_37_N {
    /**
     * Reverse a 3-digit integer.
     * You may assume the given number is larger or equal to 100 but smaller than 1000.
     * Reverse 123 you will get 321.
     * Reverse 900 you will get 9.
     *
     * @param number
     * @return
     */
    public int reverseInteger(int number) {
        // write your code here
        int digit1 = number % 10;
        int digit2 = number / 10 % 10;
        int digit3 = number /100 % 10;

        int reversedNum = digit1*100 + digit2*10 +digit3;
        return reversedNum;
    }
}
