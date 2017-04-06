package org.dongjian.jiuzhang.algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;


public class Main {
    public static void main(String[] args) {

        System.out.println("Start");
        //        Reverse3DigitInteger_37_N reverse3DigitInteger_37_n = new Reverse3DigitInteger_37_N();
//        reverse3DigitInteger_37_n.reverseInteger(123);

//        SecondMaxOfArray_479_N secondMaxOfArray = new SecondMaxOfArray_479_N();
//        int[] numss = {1,2,3,7,3,6,3};
//        System.out.println(secondMaxOfArray.secondMax(numss)); //should return 6;
//
//        System.out.println(CharToInteger_449_N.charToInteger('a'));


//        System.out.println(Palindromenumsber_491_E.palindromenumsber(1234321));
//        System.out.println(Palindromenumsber_491_E.palindromenumsber(123321));
//        System.out.println(Palindromenumsber_491_E.palindromenumsber(123312));

//        System.out.println('a'-'1');
//        PrimeFactorization_234_N test = new PrimeFactorization_234_N();
//        test.amicablePair(300);

//        final GregorianCalendar date = new GregorianCalendar(1990, 8, 29);
//        GregorianCalendar muteDate = date;
//        System.out.println("date" + date.get(1));
//        System.out.println("muteDate" + muteDate.get(1));
//        muteDate.set(1989, 3, 7);
//        date.set(1989, 3, 7);
//        System.out.println("date" + date.get(1));
//        System.out.println("muteDate" + date.get(1));
//
//
//        int year = 1000000;
//        char ch = (char) year;
//        System.out.println(ch);
//        System.out.println((char) 65535);
//
//
//        int[][] matrix = new int[][]{
//                {1, 2, 3},
//                {1, 2, 3, 4},
//                {1, 2, 3, 4, 5}
//        };

//        System.out.println(Arrays.toString(matrix));

//        Person a = new Person("a");
//        Person b = new Person("b");
//        swap(a, b);
//        System.out.println(a.name);
//        System.out.println(b.name);


//        ListNode node = new ListNode(3);
//        node.next = new ListNode(4);
//        node.next.next = new ListNode(4);
//        node.next.next.next = new ListNode(3);

//        PalindromeLinkedList_223_M newFunction = new PalindromeLinkedList_223_M();
//        newFunction.isPalindrome(node);


        //---------Test Arrays.copyOfRange()----------------;
//        int[] array = new int[]{1,2,3,4,5};
//        int[] array1 = Arrays.copyOfRange(array,3,5);
//        System.out.println(Arrays.toString(array1));

        //---------Test Array property----------------------;
//        int[] a = {1, 2, 3, 4, 5};
//        addOneNumber(a);
//        System.out.println(Arrays.toString(a));


        //---------Test Merge Interval-----------------------;
//        Interval interval = new Interval(2,3);
//        Interval interval1 = new Interval(2,2);
//        Interval interval2 = new Interval(3,3);
//        Interval interval3 = new Interval(1,3);
//        Interval interval4 = new Interval(5,7);
//        Interval interval5 = new Interval(2,2);
//        Interval interval6 = new Interval(4,6);
//
//        List<Interval> list = new ArrayList<>();
//        list.add(interval);
//        list.add(interval1);
//        list.add(interval2);
//        list.add(interval3);
//        list.add(interval4);
//        list.add(interval5);
//        list.add(interval6);
//
//        MergeIntervals_156_E test = new MergeIntervals_156_E();
//        test.merge(list);


        System.out.println(Integer.parseInt("111111111"));

        int[][] image = {{1,2},{3,4}};

    }

    private static void addOneNumber(int[] a) {
        a[a.length - 1] = 0;
    }


    public static void swap(Person a, Person b) {
        Person temp = new Person("temp");
        a = temp;
    }




    static class Person{
        String name;
        public Person(String name){
            this.name = name;
        }
    }

}
