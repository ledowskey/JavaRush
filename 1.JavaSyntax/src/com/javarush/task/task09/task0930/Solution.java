package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }
        String[] array = list.toArray(new String[list.size()]);
        sort(array);
        for (String x : array) {
            System.out.println(x);
        }
    }
    public static void sort(String[] array) {
        //напишите тут ваш код
        //Отделил цифры от строк
        ArrayList<String> numbersList = new ArrayList<String>();
        ArrayList<String> stringsList = new ArrayList<String>();
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i])) {
                numbersList.add(array[i]);
            } else {
                stringsList.add(array[i]);
            }
        }
        //Преобразовал ArrayList в массив
        String[] arrayNumbers = numbersList.toArray(new String[numbersList.size()]);
        String[] arrayStrings = stringsList.toArray(new String[stringsList.size()]);
        //Упорядочил числа по убыванию
        for (int i=0; i<arrayNumbers.length; i++)
        {
            for (int j = arrayNumbers.length - 1; j > i; j--)
            {
                if (Integer.parseInt(arrayNumbers[j]) > Integer.parseInt(arrayNumbers[j-1]))
                {
                    String temp = arrayNumbers[j];
                    arrayNumbers[j] = arrayNumbers[j-1];
                    arrayNumbers[j-1] = temp;
                }
            }
        }
        //Упорядочил строки по возрастанию
        for (int i=0; i < arrayStrings.length; i++)
        {
            for (int j = arrayStrings.length - 1; j > i; j--)
            {
                if (isGreaterThan(arrayStrings[j-1], arrayStrings[j]))
                {
                    String temp = arrayStrings[j];
                    arrayStrings[j] = arrayStrings[j-1];
                    arrayStrings[j-1] = temp;
                }
            }
        }
        //Заменил в изначальном массиве отсортированные числа и строки
        int numberCount=0;
        int stringsCount=0;
        for (int i=0; i < array.length; i++)
        {
            if (isNumber(array[i])) {
                array[i] = arrayNumbers[numberCount];
                numberCount++;
            }
            else
            {
                array[i] = arrayStrings[stringsCount];
                stringsCount++;
            }
        }
    }
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}