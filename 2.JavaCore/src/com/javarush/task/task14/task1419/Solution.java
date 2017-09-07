package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        try {
            float i = 1 / 0;

        } catch (ArithmeticException e) {
            exceptions.add(e);
        }

        try {
            int num = Integer.parseInt("Hello!");
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }

        try {
            int[] array = new int[0];
            array[1] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> nums = new ArrayList<>(2);
            int temp = nums.get(3);
        } catch (IndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        try {
            Object obj = null;
            System.out.println(obj.toString());
        } catch (NullPointerException e) {
            exceptions.add(e);
        }

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("null")));
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        try {
            String s = null;
            Object x = new Integer(0);
            s = (String) x;
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            int a = -10;
            int b = -1000;
            int[] asd = new int[a + b];

        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        try {
            String str = "easysteps2buildwebsite";
            System.out.println(str.length());
            char c = str.charAt(0);
            c = str.charAt(40);
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e9) {
            exceptions.add(e9);
        }


    }
}
