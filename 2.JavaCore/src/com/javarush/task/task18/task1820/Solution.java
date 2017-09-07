package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);

        reader = new BufferedReader(new InputStreamReader(inputStream));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName2)));

        while (reader.ready()) {
            String[] sData = reader.readLine().split(" ");

//            for (String s : sData) {
//                System.out.println(s);
//            }

            for (int i = 0; i < sData.length; i++) {
                String iData = String.valueOf(Math.round(Double.parseDouble(sData[i])));
                writer.write(iData + " ");
            }
        }

        reader.close();
        inputStream.close();
        writer.close();

    }
}
