package com.javarush.task.task17.task1718;

/* 
Глажка
*/

public class Solution {
    public static void main(String[] args) {
        Person diana = new Person("Diana");
        Person igor = new Person("Igor");
        diana.start();
        igor.start();
    }

    public static class Person extends Thread { //Человек

        public Person(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (Iron.class) {
                Iron iron = new Iron();
                iron.takeIron();
                Clothes clothes = takeClothes();
                ironing(iron, clothes);
                iron.returnIron();
            }
        }



        protected Clothes takeClothes() {
            return new Clothes("T-shirt");
        }

        protected void ironing(Iron iron, Clothes clothes) {
            System.out.println(getName() + "'s ironing the " + clothes.name);
        }
    }

    public static class Iron {
        protected Iron takeIron() {
        System.out.println("Taking an Iron");
        return new Iron();
    }

        protected Iron returnIron() {
            System.out.println("Returning the Iron");
            return new Iron();
        }
    } //Утюг

    public static class Clothes {//Одежда
        String name;

        public Clothes(String name) {
            this.name = name;
        }
    }
}
