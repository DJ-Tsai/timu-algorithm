package org.dongjian.jiuzhang.algorithm.hard;

/**
 * Implement function atoi to convert a string to an integer.
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * <p>
 * Created by Dj on 1/10/17.
 */
public class StringToIntergerII_54_H {

    public static int atoi(String str) {
        /*
        Round 1
         */
//        int sign = 1;
//        char[] charArray = str.trim().toCharArray();
//        double result = 0;
//        // loop start from the last significant digit
//        for (int i = 0; i < charArray.length; i++) {
//            switch (charArray[i]) {
//                case '1':
//                    result = result + 1 * Math.pow(10, charArray.length - i - 1);break;
//                case '2':
//                    result = result + 2 * Math.pow(10, charArray.length - i - 1);break;
//                case '3':
//                    result = result + 3 * Math.pow(10, charArray.length - i - 1);break;
//                case '4':
//                    result = result + 4 * Math.pow(10, charArray.length - i - 1);break;
//                case '5':
//                    result = result + 5 * Math.pow(10, charArray.length - i - 1);break;
//                case '6':
//                    result = result + 6 * Math.pow(10, charArray.length - i - 1);break;
//                case '7':
//                    result = result + 7 * Math.pow(10, charArray.length - i - 1);break;
//                case '8':
//                    result = result + 8 * Math.pow(10, charArray.length - i - 1);break;
//                case '9':
//                    result = result + 9 * Math.pow(10, charArray.length - i - 1);break;
//                case '0':
//                    result = result;break;
//                case '-':
//                    if (i == 0) {
//                        sign = -1;
//                    }else {
//                        return 0;
//                    }
//                    break;
//                default:
//                    return 0;
//            }
//        }
//        result = sign * result;
//
//        if (result > Integer.MAX_VALUE ) {
//            return Integer.MAX_VALUE;
//        } else if (result < Integer.MIN_VALUE) {
//            return Integer.MIN_VALUE;
//        } else {
//            return (int)result;
//        }

        /*
        round 2
         */
        int index = 0;
        int sign = 1;
        long result = 0;
        str = str.trim();
        if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        for (; index < str.length(); index++) {
            if (isValid(str.charAt(index))) {
                result = result * 10 + str.charAt(index) - '0';
            } else if (result > Integer.MAX_VALUE) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                return (int)result *sign;
            }
        }
        return (int)result *sign;
    }

    public static boolean isValid(final char chr) {
        if (chr >= '0' && chr <= '9') return true;
        return false;
    }
}
