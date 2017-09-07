package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(br.readLine());
//        FileInputStream fileInputStream = new FileInputStream("C:\\JavaRush\\3.properties");
        br.close();
        load(fileInputStream);
    }

    public void save(OutputStream outputStream) throws Exception {

        Properties props = new Properties();
        props.putAll(properties);
        props.store(outputStream,"");
        outputStream.flush();
        outputStream.close();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties props = new Properties();

        props.load(inputStream);
        Set<String> list = props.stringPropertyNames();
        for (String l : list) {
            properties.put(l, props.getProperty(l));
        }
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {

        new Solution().fillInPropertiesMap();
        new Solution().save(new FileOutputStream("C:\\JavaRush\\3.properties"));

    }
}
