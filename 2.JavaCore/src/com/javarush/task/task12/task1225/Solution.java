package com.javarush.task.task12.task1225;

/* 
Посетители
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        boolean animal = (o instanceof Animal);
        boolean cat = (o instanceof Cat);
        boolean tiger = (o instanceof Tiger);
        boolean lion = (o instanceof Lion);
        boolean bull = (o instanceof Bull);
        boolean cow = (o instanceof Cow);

        if(animal && cat && !tiger && !lion) return "Кот";
        else if(animal && cat && tiger && !lion) return "Тигр";
        else if(animal && cat && !tiger && lion) return "Лев";
        else if(animal && bull && !cow) return "Бык";
        else if(animal && !bull && cow) return "Корова";
        else return "Животное";
    }

    public static class Cat extends Animal   //<--Классы наследуются!!
    {
    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}
