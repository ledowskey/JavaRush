package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<>();

        FileInputStream inputStream = null;

        String nextFileName = null;
        //Читаем файлы пока не "end"
        while (true) {
            if ("end".equals(nextFileName = reader.readLine())) break;
            else list.add(nextFileName);
        }
        reader.close();

        Collections.sort(list);

        //Выходной файловый поток
        String outputFileName = list.get(0).split(".part")[0];
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName);

        //Сливаем файлы
        for (String partsFileNames : list) {
            inputStream = new FileInputStream(partsFileNames);
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            fileOutputStream.write(buffer);
            inputStream.close();
        }
        fileOutputStream.close();
        System.out.println("Объединение файлов выполнено!");
    }
}
