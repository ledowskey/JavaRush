package com.javarush.task.task14.task1408;

/**
 * Created by DELL on 08.08.2017.
 */
public class MoldovanHen extends Hen {

    @Override
    public int getCountOfEggsPerMonth() {
        return 5200;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
