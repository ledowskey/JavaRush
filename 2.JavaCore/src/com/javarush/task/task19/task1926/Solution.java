package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader(br.readLine()));
        br.close();

        while (reader.ready()) {
            String line = reader.readLine();
            StringBuilder sb = new StringBuilder(line);
            sb.reverse();
            System.out.println(sb.toString());
        }
        reader.close();

    }
}
