package org.dongjian.jiuzhang.algorithm.easy;

/**
 * You know what, left pad is javascript package and referenced by React:
 * Github link
 * <p>
 * One day his author unpublished it, then a lot of javascript projects in the world broken.
 * <p>
 * You can see from github it's only 11 lines.
 * <p>
 * You job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.
 * <p>
 * Example
 * leftpad("foo", 5)
 * >> "  foo"
 * <p>
 * leftpad("foobar", 6)
 * >> "foobar"
 * <p>
 * leftpad("1", 2, "0")
 * >> "01"
 */
public class LeftPad_524_E {
    static public String leftPad(String originalStr, int size) {
        if (size <= originalStr.length()) {
            return originalStr;
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            b.append(' ');
        }
        b.append(originalStr);
        return b.toString();
    }

    /**
     * @param originalStr the string we want to append to
     * @param size        the target length of the string
     * @param padChar     the character to pad to the left side of the string
     * @return a string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        if (size <= originalStr.length()) {
            return originalStr;
        }

        StringBuilder b = new StringBuilder();
        for (int i = 0; i < size - originalStr.length(); i++) {
            b.append(padChar);
        }
        b.append(originalStr);
        return b.toString();
    }
}
