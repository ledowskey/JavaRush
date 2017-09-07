package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<String,Double>();
        while (reader.ready()) {
            String[] line = reader.readLine().split(" ");
            if(map.containsKey(line[0])) {
                map.put(line[0], map.get(line[0]) + Double.parseDouble(line[1]));
            } else map.put(line[0], Double.parseDouble(line[1]));
        }
        reader.close();
        for (Map.Entry<String,Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
