package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inStream = new FileInputStream(reader.readLine());

//        ArrayList<Integer> list = new ArrayList<>();

        int max = 0;

        while (inStream.available() > 0) {
//            list.add(inStream.read());
            int data = inStream.read();

            if(data > max) {
                max = data;
            }
        }

//        Collections.sort(list);

//        System.out.println(list.get(list.size()-1));

        System.out.println(max);

        reader.close();inStream.close();
    }
}
