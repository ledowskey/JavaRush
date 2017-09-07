package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);

        testString.printSomething();

        System.setOut(consoleStream);

        String temp = baos.toString();  // 3 + 6 = ...
        String[] strings = temp.split(" ");
        int result = 0;
        switch (strings[1]) {
            case "+" :
                result = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);   // 3 + 6 = 9;
                break;
            case "-":
                result = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);   // 3 - 6 = -3;
                break;
            case "*":
                result = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);   // 3 * 6 = 18;
                break;
        }
        System.out.println(temp + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

