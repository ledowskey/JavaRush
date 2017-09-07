package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory implements Country {

        static Hen getHen(String country) {
            Hen hen = null;
            switch (country) {
                case UKRAINE:
                    hen = new UkrainianHen();
                    break;
                case RUSSIA:
                    hen = new RussianHen();
                    break;
                case MOLDOVA:
                    hen = new MoldovanHen();
                    break;
                case BELARUS:
                    hen = new BelarusianHen();
                    break;
                default: hen = new UkrainianHen();
            }

            return hen;
        }
    }
}
