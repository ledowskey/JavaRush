package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());

        Set<Integer> setList = new TreeSet<>(); // Automatic sorting in TreeSet.

        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if(!setList.contains(data)) {
                setList.add(data);
            }
        }

        reader.close();
        inputStream.close();

        for (int i : setList) {
            System.out.print(i + " ");
        }
    }
}
