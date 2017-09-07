package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileOutputStream outputStream = new FileOutputStream(fileName1);

        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);

        while (inputStream2.available() > 0) {
            int data = inputStream2.read();
            outputStream.write(data);
        }

        while (inputStream3.available() > 0) {
            int data = inputStream3.read();
            outputStream.write(data);
        }

        reader.close();
        outputStream.close();
        inputStream2.close();
        inputStream3.close();
    }
}
