package com.javarush.task.task16.task1618;

/* 
Снова interrupt
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        TestThread test = new TestThread();
//        Thread testThread = new Thread(test);

        test.start();

        test.interrupt();
    }

    public static class TestThread extends Thread {

        public TestThread() {
        }

        @Override
        public void run() {

        }
    }
}