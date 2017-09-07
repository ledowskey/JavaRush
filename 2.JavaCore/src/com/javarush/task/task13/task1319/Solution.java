package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

        while(true) {
            String s = reader.readLine();

            if(s.equals("exit")) {
                break;
            }
            s = s + "\n";
            writer.write(s);
        }
        writer.write("exit");

        reader.close();
        writer.close();






















//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Maven/test.txt")));
//
//        while(true){
//            String s = reader.readLine();
//            if(s.equals("exit"))
//                break;
//            s += "\r\n";
//            writer.write(s);
//        }
//        writer.write("exit\r\n");
//
//        writer.close();
//        reader.close();
    }
}
