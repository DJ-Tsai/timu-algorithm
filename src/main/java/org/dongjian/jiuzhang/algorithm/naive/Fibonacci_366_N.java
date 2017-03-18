package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/10/17.
 */
public class Fibonacci_366_N {
    public int fibonacci(int n) {
        // write your code here
        int a = 0;
        int b = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return a;
    }
}
