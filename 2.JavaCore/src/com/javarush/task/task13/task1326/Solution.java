package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        ArrayList<Integer> arrayList = new ArrayList<>();

        while(reader.ready()) {
            String sData = reader.readLine();
            int data = Integer.parseInt(sData);

            if(data % 2 == 0) arrayList.add(data);
        }

        Collections.sort(arrayList);

        for(int i : arrayList) {
            System.out.println(i);
        }

        reader.close();




    }
}
