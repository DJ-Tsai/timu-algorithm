package org.dongjian.jiuzhang.algorithm.naive;

import java.util.ArrayList;

/**
 * Created by Dj on 1/10/17.
 */
public class RootOfEquation_239_N {
    public double[] rootOfEquation(double a, double b, double c) {
        // Write your code here
        double[] rootArray = new double[2];
        double condition = b * b - 4 * a * c;
        if (condition < 0) {
            return new double[]{};
        } else if (condition == 0) {
            return new double[]{-b / (2 * a)};
        } else if (a > 0) {
            return new double[]{(-b - Math.sqrt(condition)) / (2 * a), (-b + Math.sqrt(condition)) / (2 * a)};
        } else {
            return new double[]{(-b + Math.sqrt(condition)) / (2 * a),(-b - Math.sqrt(condition)) / (2 * a)};
        }
    }

}
