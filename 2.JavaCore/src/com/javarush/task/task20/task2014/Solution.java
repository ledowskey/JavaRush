package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String fileName = "C:\\JavaRush\\4.data";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));

        Solution savedObject = new Solution(5);
        System.out.println("savedObject: \t" + savedObject.string);
        out.writeObject(savedObject);

        // ------------------------

        Solution loadedObject = (Solution)in.readObject();
        System.out.println("loadedObject: \t" + loadedObject.string);

        System.out.println(savedObject.string.equals(loadedObject.string) ? "Объекты равны" : "Объекты не равны");




    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
