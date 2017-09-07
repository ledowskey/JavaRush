package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int countSeconds = 3;
    public static int distance = 3500;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();

        Thread.sleep(distance);

        clock.interrupt();


    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            this.start();
        }

        public void run() {
            Thread current = Thread.currentThread();
            try {
                while (countSeconds > 0) {
                    System.out.print(countSeconds + " ");
                    Thread.sleep(1000);
                    countSeconds--;
                }
                System.out.println("Марш!");
            }
            catch (InterruptedException e) {
                System.out.println("Прервано!");
            }
        }
    }
}
