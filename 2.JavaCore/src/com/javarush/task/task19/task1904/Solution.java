package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{

        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            fileScanner = new Scanner(System.in);
            String[] personData = fileScanner.nextLine().split(" ");

            if(personData.length != 6) System.out.println("Something went wrong ...");

            String lastName = personData[0];
            String firstName = personData[1];
            String middleName = personData[2];
            String birthDate = String.format("%s %s %s", personData[3], personData[4], personData[5]);

            Date pBirthDate = new SimpleDateFormat("dd mm yyyy", Locale.ENGLISH).parse(birthDate);

            Person person = new Person(firstName, middleName, lastName, pBirthDate);

            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
