package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
StringTokenizer

getTokens("level22.lesson13.task01", ".")
{"level22", "lesson13", "task01"}

*/
public class Solution {
    public static void main(String[] args) {
        String query = "level22.lesson13.task01";
        String delimiter = "";
        System.out.println(Arrays.toString(getTokens(query, delimiter)));
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        ArrayList<String> list = new ArrayList<>();

        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        String[] array = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            array[i] = list.get(i);
        }

        return array;
    }
}
