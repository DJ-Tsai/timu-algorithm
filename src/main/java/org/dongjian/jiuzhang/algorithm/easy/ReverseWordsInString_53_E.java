package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p>
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class ReverseWordsInString_53_E {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        s = s.trim();

        if (s.isEmpty()) {
            return s;
        }

        String[] res = s.split("( )+");

        StringBuilder builder = new StringBuilder();

        builder.append(res[res.length - 1]);

        for (int i = res.length - 2; i >= 0; i--) {
            builder.append(" ").append(res[i]);
        }

        return builder.toString();
    }
}
