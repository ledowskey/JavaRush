package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(reader.readLine());


        HashMap<Integer,Integer> listMap = new HashMap<>();

        while (inputStream.available() > 0) {
           int d = inputStream.read();

           if(listMap.containsKey(d)) {
               listMap.put(d, listMap.get(d) + 1);
           } else {
               listMap.put(d, 1);
           }
        }

//        for (Map.Entry<Integer,Integer> pair : listMap.entrySet()) {
//            System.out.println(pair.getKey() + " " + pair.getValue());
//        }

        int max = 0;
        for (Integer value : listMap.values()) {
            if(value > max) max = value;
        }

        for (Map.Entry pair : listMap.entrySet()) {
            if(pair.getValue().equals(max)) System.out.print(pair.getKey() + " ");
        }

        reader.close();
        inputStream.close();
    }
}
