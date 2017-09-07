package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";

        while(true) {
            fileName = reader.readLine();
            FileInputStream inputStream = new FileInputStream(fileName);

            if(inputStream.available() < 1000) {
                reader.close();
                inputStream.close();

                throw new DownloadException();
            } else inputStream.close();
        }

    }

    public static class DownloadException extends Exception {

    }
}
