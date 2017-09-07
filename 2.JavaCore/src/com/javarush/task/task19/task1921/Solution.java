package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));

        while (reader.ready()) {
            String line = reader.readLine();
            String nameStr = line.replaceAll("\\w", "").trim();
            String[] birthdat = line.substring(nameStr.length()).trim().split(" ");
            int day = Integer.parseInt(birthdat[0]);
            int month = Integer.parseInt(birthdat[1]);
            int year = Integer.parseInt(birthdat[2]);

            Date date = new GregorianCalendar(year,month-1,day).getTime();

            PEOPLE.add(new Person(nameStr, date));
        }
        reader.close();
    }
}
