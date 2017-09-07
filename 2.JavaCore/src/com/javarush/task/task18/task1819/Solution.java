package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();

        FileInputStream inputStream = new FileInputStream(fileName1);

        int[] buffer = new int[inputStream.available()];

        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = inputStream.read();
        }

        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);

        while (inputStream2.available() > 0) {
            int data = inputStream2.read();
            outputStream.write(data);
        }
        inputStream2.close();

        for (int i = 0; i < buffer.length; i++) {
            outputStream.write(buffer[i]);
        }

        outputStream.close();
    }
}
