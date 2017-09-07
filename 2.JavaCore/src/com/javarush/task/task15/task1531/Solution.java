package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger fact = BigInteger.valueOf(1);

        if(n <= 150 && n > 0) {
            for(int i = 2; i <= n; i++) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
        } else if(n < 0) {
            return "0";
        } else if(n == 0) {
            return "1";
        } else return "";
//        else System.out.println("Looks like you have entered number bigger than 150");

        return String.valueOf(fact);
    }
}
