package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Person person = null;

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for(int i = 1; i < args.length; i+=3) {
                        allPeople.add(createPerson(args[i], args[i+1], args[i+2]));
                        System.out.println(allPeople.size()-1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=4) {
                        person = allPeople.get(Integer.parseInt(args[i]));

                        person.setName(args[i+1]);
                        person.setBirthDay(new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[i+3]));

                        if(args[i+2].equals("ж")) person.setSex(Sex.FEMALE);
                        if(args[i+2].equals("м")) person.setSex(Sex.MALE);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {

                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));

                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDay(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {

                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));

                        String str = "";
                        if(person.getSex().equals(Sex.FEMALE)) str = "ж";
                        if(person.getSex().equals(Sex.MALE)) str = "м";

                        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        String date = simpleDateFormat.format(person.getBirthDay());

                        System.out.println(person.getName() + " " + str + " " + date);
                    }
                }
                break;
        }
    }

    public static Person createPerson(String name, String sex, String birthday) throws ParseException {
        Person newPerson = null;
        if(sex.equals("м")) {
            newPerson = Person.createMale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday));
        } else if(sex.equals("ж")) {
            newPerson = Person.createFemale(name, new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(birthday));
        }
        return newPerson;
    }
}
