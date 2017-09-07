package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = reader.readLine();
        String str2 = reader.readLine();

        int num1 = 0;
        int num2 = 0;

            num1 = Integer.parseInt(str1);
            num2 = Integer.parseInt(str2);

            if (num1 <= 0 || num2 <= 0) throw new Exception();

        int maximum = 0;

        for (int i = 1; i < Integer.min(num1,num2); i++) {
            for (int j = 1; j < Integer.max(num1,num2); j++) {
                if (num1 % j == 0 && num2 % j == 0) {
                    maximum = j;
                }
            }
        }

        System.out.println(maximum);
    }
}

