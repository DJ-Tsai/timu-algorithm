package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Write a method to replace all spaces in a string with %20. The string is given in a characters array, you can assume it has enough space for replacement and you are given the true length of the string.
 * <p>
 * You code should also return the new length of the string after replacement.
 * <p>
 * Example
 * Given "Mr John Smith", length = 13.
 * <p>
 * The string after replacement should be "Mr%20John%20Smith", you need to change the string in-place and return the new length 17.
 * <p>
 * Challenge
 * Do it in-place.
 * <p>
 * Notice
 * <p>
 * If you are using Java or Python，please use characters array instead of string.
 */
public class SpaceReplacement_212_E {
    public int replaceBlank(char[] string, int length) {
        // count of space
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (string[i] == ' ') {
                count++;
            }
        }

        int newLen = length + 2 * count;
        int right = newLen - 1;
        for (int i = length - 1; i >= 0; i--) {
            if (string[i] != ' ') {
                string[right--] = string[i];
            } else {
                string[right--] = '0';
                string[right--] = '2';
                string[right--] = '%';
            }
        }

        return newLen;
    }
}
