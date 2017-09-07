package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream(args[0]);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        int countChars = 0, countSpaces = 0;

        while (reader.ready()) {
            String data = reader.readLine();
            char[] cData = data.toCharArray();

            for (char c : cData) {
                if (Character.toString(c).equals(" ")) {
                    countSpaces++;
                    countChars++;
                } else countChars++;
            }
        }

        double ratio = (double) countSpaces / countChars * 100;

        System.out.print(String.format("%(.2f", ratio));

        inputStream.close();
        reader.close();
    }
}
