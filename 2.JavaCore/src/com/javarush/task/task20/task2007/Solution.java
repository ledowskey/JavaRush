package com.javarush.task.task20.task2007;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Как сериализовать JavaRush?
*/
public class Solution {
    public static class JavaRush implements Serializable {
        public List<User> users = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\JavaRush\\3.data");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        JavaRush javaRush = new JavaRush();
        outputStream.writeObject(javaRush);

    }
}
