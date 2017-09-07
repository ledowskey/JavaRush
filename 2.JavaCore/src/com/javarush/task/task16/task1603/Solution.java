package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread special1 = new SpecialThread();
        Thread thread1 = new Thread(special1);
        list.add(thread1);
        thread1.run();

        SpecialThread special2 = new SpecialThread();
        Thread thread2 = new Thread(special2);
        list.add(thread2);
        thread2.run();

        SpecialThread special3 = new SpecialThread();
        Thread thread3 = new Thread(special3);
        list.add(thread3);
        thread3.run();

        SpecialThread special4 = new SpecialThread();
        Thread thread4 = new Thread(special4);
        list.add(thread4);
        thread4.run();

        SpecialThread special5 = new SpecialThread();
        Thread thread5 = new Thread(special5);
        list.add(thread5);
        thread5.run();
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
