package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Maven\\JavaRush\\1.txt"));
//        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Maven\\JavaRush\\2.txt"));

        while (reader.ready()){
            String line = reader.readLine();
            String[] words = line.split(" ");
            for (String word : words)
                if (!word.matches("^\\D*$")){
                    writer.write(word + " ");
                    System.out.println(word);
                }
        }
        reader.close();
        writer.close();
    }
}
