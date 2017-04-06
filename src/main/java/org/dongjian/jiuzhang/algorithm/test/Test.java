package org.dongjian.jiuzhang.algorithm.test;

import java.util.PriorityQueue;

/**
 * Created by Dj on 1/28/17.
 */
public class Test {
     String str = "string";
     Integer integer = new Integer(10);

     @org.junit.Test
     public void test1() {
          appendString(str);
          System.out.println(str);


     }

     @org.junit.Test
     public void test2() {
          PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

          queue.offer(1);
          queue.offer(2);
          System.out.println(queue.peek());
     }



     public void appendString(String string) {
          string = string + "append";
     }

     public void incrementInt(Integer integer) {

     }

}
