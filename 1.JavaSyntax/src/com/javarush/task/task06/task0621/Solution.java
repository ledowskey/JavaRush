package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat grandFatherCat = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        Cat grandMotherCat = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat fatherCat = new Cat(fatherName,null, grandFatherCat);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, grandMotherCat, null);

        String sonName = reader.readLine();
        Cat sonCat = new Cat(sonName, catMother, fatherCat);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, fatherCat);

        System.out.println(grandFatherCat);
        System.out.println(grandMotherCat);
        System.out.println(fatherCat);
        System.out.println(catMother);
        System.out.println(sonCat);
        System.out.println(catDaughter);
    }

    public static class Cat {
        private String name;
        private Cat parentMother;
        private Cat parentFather;

        Cat(String name) {

            this.name = name;
        }

        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            this.parentMother = parent1;
            this.parentFather = parent2;
        }

        @Override
        public String toString() {
            String mother, father;
            if (parentMother == null) mother = ", no mother";
            else mother = ", mother is " + parentMother.name;
            if(parentFather == null) father = ", no father";
            else father = ", father is " + parentFather.name;

            return "Cat name is " + name + mother + father;
//                return "Cat name is " + name + ", no mother, no father ";
//            else if(parentMother != null)
//                return "Cat name is " + name + ", mother is " + parentMother.name + ", no father";
//            else if(parentFather != null)
//                return "Cat name is " + name + ", no mother, father is " + parentFather.name;
//            else return "Cat name is " + name + ", mother is " + parentMother.name + ", father is " + parentFather.name;
        }
    }

}
