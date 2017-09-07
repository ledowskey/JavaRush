package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        String filename1 = args[0];
        String filename2 = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(filename1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename2));

        StringBuilder sb = new StringBuilder();
        String line = "";
        while (reader.ready()) {
            line = reader.readLine();

            for (String lines : line.split(" ")) {
                if (lines.length() > 6) {
                    sb.append(lines).append(",");
                }
            }
        }
        reader.close();

        sb.delete(sb.length()-1, sb.length());
        writer.write(sb.toString());
        writer.close();

    }
}
