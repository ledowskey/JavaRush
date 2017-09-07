package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName  = reader.readLine();

        String id = args[0];

        FileInputStream inputStream = new FileInputStream(fileName);

        reader = new BufferedReader(new InputStreamReader(inputStream));

        while (reader.ready()) {
            String line = reader.readLine();
            String[] sLine = line.split(" ");

            for (int i = 0; i < sLine.length; i++) {
                if(sLine[i].equals(id)) {
                    String productName = sLine[i+1];
                    String price = sLine[i+2];
                    String quality = sLine[i+3];

                    System.out.println(id + " " + productName + " " + price + " " + quality);
                }
            }
        }

        reader.close();
        inputStream.close();
    }
}
