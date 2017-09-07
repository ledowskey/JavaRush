package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();

        String sData = "";
        while (fileReader.ready()) {
            sData = sData + (char)fileReader.read();
        }

        String data = sData.replaceAll("[\\p{Punct}+|\\s]"," ");
        String[] words = data.split(" ");

        int count = 0;
        for (String s : words) {
            if(s.equals("world")) {
                count++;
            }
        }
        fileReader.close();
        System.out.println(count);
    }
}
