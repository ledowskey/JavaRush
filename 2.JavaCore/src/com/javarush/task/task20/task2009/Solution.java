package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "it's test static string";
        public int i;
        public int j;
    }

    public static void main(String[] args) throws Exception {

        ClassWithStatic classWithStatic = new ClassWithStatic();

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\JavaRush\\4.data");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(classWithStatic);
        outputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:\\JavaRush\\4.data");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ClassWithStatic classWithStatic1 = (ClassWithStatic)objectInputStream.readObject();
    }
}
