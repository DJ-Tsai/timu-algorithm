package org.dongjian.jiuzhang.algorithm.easy;

/**
 *
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 *
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 */
public class RotateString_8_E {
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (str.length == 0 || str.length == 1) {
            return;
        }

        char temp;
        int count = offset % str.length;
        for (int i = 0; i < count; i++) {
            temp = str[str.length - 1];
            for (int k = str.length - 1; k >= 1; k--) {
                str[k] = str[k - 1];
            }
            str[0] = temp;
        }
    }
}
