package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/11/17.
 */
public class StringToInteger_241_N {
    /**
     * @param str a string
     * @return an integer
     */
    public int stringToInteger(String str) {
        // Write your code here
        int index = 0;
        int sign = 1;
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        int result = 0;

        for (; index < str.length(); index++) {
            result = result *10 + (str.charAt(index)-'0');
        }

        return result*sign;
    }
}
