package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Looser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Person person = null;

        String key = null;

        while(true) {
            key = reader.readLine();

            if (!(key.equals("user") || key.equals("loser") || key.equals("coder") || key.equals("proger")))
                break;
            else if(key.equalsIgnoreCase("user")) person = new Person.User();
            else if(key.equalsIgnoreCase("loser")) person = new Person.Loser();
            else if(key.equalsIgnoreCase("coder")) person = new Person.Coder();
            else if(key.equalsIgnoreCase("proger")) person = new Person.Proger();

            doWork(person);
        }

        reader.close();
    }

    public static void doWork(Person person) {
        if(person instanceof Person.User) ((Person.User) person).live();
        else if(person instanceof Person.Coder) ((Person.Coder) person).coding();
        else if(person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if(person instanceof Person.Proger) ((Person.Proger) person).enjoy();
    }
}
