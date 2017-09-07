package com.javarush.task.task15.task1529;

/**
 * Created by DELL on 11.08.2017.
 */
public class Plane implements Flyable {

    private int passCount;

    public Plane(int passCount) {
        this.passCount = passCount;
    }

    @Override
    public void fly() {

    }
}
