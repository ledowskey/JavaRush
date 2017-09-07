package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(3.0, "item1");
        labels.put(4.0, "item2");
        labels.put(5.0, "item3");
        labels.put(6.0, "item4");
        labels.put(7.0, "item5");
    }

    public static void main(String[] args) {
        System.out.println(labels);

    }
}
