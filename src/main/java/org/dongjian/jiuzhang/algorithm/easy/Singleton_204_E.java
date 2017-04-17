package org.dongjian.jiuzhang.algorithm.easy;

/**
 * Singleton is a most widely used design pattern. If a class has and only has one instance at every moment, we call this design as singleton. For example, for class Mouse (not a animal mouse), we should design it in singleton.
 * <p>
 * You job is to implement a getInstance method for given class, return the same instance of this class every time you call this method.
 */
public class Singleton_204_E {
    public static Singleton_204_E instance = null;

    public static Singleton_204_E getInstance() {
        if (instance == null) {
            instance = new Singleton_204_E();
        }
        return instance;
    }
}
