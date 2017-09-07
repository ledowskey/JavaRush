package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String fileName = reader.readLine();

            if(fileName.equals("exit")) break;
            new ReadThread(fileName).start();
        }

        reader.close();

    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {

            Map<Integer,Integer> map = new HashMap<>();

            try {
                    FileInputStream inputStream = new FileInputStream(fileName);

                    while (inputStream.available() > 0) {

                        int num = inputStream.read();

                        if (map.containsKey(num)) {
                            map.put(num, map.get(num) + 1);
                        } else map.put(num, 1);
                    }
                    inputStream.close();

                    int max = 0;
                    for (Integer m : map.values()) {
                        if (max == 0) max = m;
                        if(m > max) max = m;
                    }

                    synchronized (resultMap) {
                        for (Map.Entry<Integer,Integer> pair : map.entrySet()) {
                            if (pair.getValue().equals(max)) resultMap.put(fileName, pair.getKey());
                        }
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException");
                } catch (IOException e) {
                    System.out.println("IOException");
                }
        }
    }
}
