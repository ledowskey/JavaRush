package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String f1 = "C:\\Maven\\JavaRush\\allLines.txt";
//        String f2 = "C:\\Maven\\JavaRush\\doubles.txt";

        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        BufferedWriter writer = new BufferedWriter(new FileWriter(br.readLine()));
//        BufferedReader reader = new BufferedReader(new FileReader(f1));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(f2));
        br.close();

        String sData = "";
        while ((sData = reader.readLine()) != null) {
            sData = sData.replaceAll("\\.", "!") + "\n";
            writer.write(sData);
        }
        reader.close();
        writer.close();
    }
}
