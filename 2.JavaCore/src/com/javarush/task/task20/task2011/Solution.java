package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String adr, int y) {
            address = adr;
            year = y;
        }

        /**
         * Prints out the fields. used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
            out.close();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address = (String)in.readObject();
            year = in.readInt();
            in.close();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Apartment apartment = new Apartment();
        apartment.address = "My new address";
        apartment.year = 2005;

        apartment.writeExternal(new ObjectOutputStream(new FileOutputStream("C:\\JavaRush\\5.data")));

        Thread.sleep(3000);

        Apartment apartment1 = new Apartment();
        apartment1.readExternal(new ObjectInputStream(new FileInputStream("C:\\JavaRush\5.data")));

        System.out.println(apartment.equals(apartment1));
    }
}
