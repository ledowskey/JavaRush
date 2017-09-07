package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        String encription = args[0];
        String fileName = args[1];
        String fileOutputName = args[2];

        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);

        int magic = 10;

        if (encription.equals("-e")) {
            while (inputStream.available() > 0) {
                int data = inputStream.read();
                int encript = data + magic;
                outputStream.write(encript);
            }
        }

        if (encription.equals("-d")) {
            while (inputStream.available() > 0) {
                int encript = inputStream.read();
                int data = encript - magic;
                outputStream.write(data);
            }
        }

        inputStream.close();
        outputStream.close();

    }

}
