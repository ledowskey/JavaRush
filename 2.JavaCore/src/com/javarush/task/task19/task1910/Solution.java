package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String f1 = "C:\\Maven\\JavaRush\\allLines.txt";
//        String f2 = "C:\\Maven\\JavaRush\\doubles.txt";
//        BufferedReader reader = new BufferedReader(new FileReader(f1));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(br.readLine()));
        br.close();

        String line = "";
        while ((line = reader.readLine()) != null) {
            line = line.replaceAll("\\p{Punct}+|\\s", "");
            writer.write(line);
        }
        reader.close();
        writer.close();
    }
}
