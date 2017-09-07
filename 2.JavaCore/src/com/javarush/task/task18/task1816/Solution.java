package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        char[] english = {'a','b','c','d','e','f','g','h','i','j','k','l','m',
                          'n','o','p','q','r','s','t','u','v','w','x','y','z'};

        int count = 0;
        while (reader.ready()) {
            String data = reader.readLine();
            char[] cData = data.toCharArray();

            for (char c : cData) {
                for (char e : english) {
                    if(Character.toString(c).equalsIgnoreCase(Character.toString(e))) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
        inputStream.close();
        reader.close();
    }
}
