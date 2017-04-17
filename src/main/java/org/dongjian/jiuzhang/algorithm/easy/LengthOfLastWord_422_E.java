package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Notice
 * <p>
 * A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example
 * Given s = "Hello World       ", return 5.
 */
public class LengthOfLastWord_422_E {
    public int lengthOfLastWord(String s) {
        int count = 0;

        s = s.trim();

        if (s == null || s.isEmpty()) {
            return count;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                return count;
            }

            count++;
        }

        return count;
    }
}
