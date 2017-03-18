package org.dongjian.jiuzhang.algorithm.naive;

/**
 * Created by Dj on 1/9/17.
 */
public class SimpleCalculator_478_N {

    public int calculate(int a, char operator, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
}
