package org.dongjian.jiuzhang.algorithm.easy;

/**
 * For a given source string and a target string, you should output the first index(from 0) of target string in source string.
 *
 * If target does not exist in source, just return -1.
 *
 * If source = "source" and target = "target", return -1.
 *
 * If source = "abcdabcdefg" and target = "bcd", return 1.e
 */
public class strSTR_13_E {
    public int strStr(String source, String target) {
        //write your code here
        if (source == null || target == null) {
            return -1;
        }

        if (target.isEmpty()) {
            return 0;
        }


        char[] sourceChar = source.toCharArray();
        char[] targetChar = target.toCharArray();

        for (int i = 0; i < sourceChar.length - targetChar.length + 1; i++) {
            for (int j = 0; j < targetChar.length; j++) {
                if (targetChar[j] != sourceChar[i + j]) {
                    break;
                }
                if (j == targetChar.length -1) {
                    return i;
                }
            }
        }


        return -1;
    }
}
