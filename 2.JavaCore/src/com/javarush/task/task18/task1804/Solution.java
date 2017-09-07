package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());

        HashMap<Integer,Integer> list = new HashMap<>();

        while (inputStream.available() > 0) {
            int data = inputStream.read();

            if(list.containsKey(data)) {
                list.put(data, list.get(data) + 1);
            } else {
                list.put(data, 1);
            }
        }

        reader.close();
        inputStream.close();

        int min = 0;
        for (Integer value : list.values()) {
            if(min == 0) min = value;
//            System.out.println(min);
            if(value < min) min = value;
        }

        for(Map.Entry pair : list.entrySet()) {
            if(pair.getValue().equals(min)) System.out.print(pair.getKey() + " ");
        }
    }
}
