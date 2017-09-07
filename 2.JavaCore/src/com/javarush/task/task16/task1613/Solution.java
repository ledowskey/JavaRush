package com.javarush.task.task16.task1613;

/* 
Big Ben clock
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 58, 52);
//        Thread.sleep(400000);
//        isStopped = true;
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            String s = "";
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                s = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                while (!isStopped) {
                    if(!s.isEmpty()) {
                        printTime();
                    } else isStopped = true;
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            Thread.sleep(1000);
            seconds++;

            if(seconds == 60){
                seconds = 0;
                minutes++;
                if(minutes == 60) {
                    minutes = 0;
                    hours++;
                    if(hours == 24) {
                        hours = 0;
                    }
                }
            }

            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }
        }
    }
}
