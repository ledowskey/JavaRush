package com.javarush.task.task21.task2113;

/**
 * Created by DELL on 01.09.2017.
 */
public class Horse {
    private String name;
    private double speed;
    private double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return String.format("Horse: %s, speed - %s, distance - %s\n", getName(), getSpeed(), getDistance());
    }

    public void move() {
        setDistance(getDistance() + getSpeed() * Math.random()*1);
        System.out.println(distance);
    }
    public void print() {
        for (int i = 0; i < (int)getDistance(); i++) {
            System.out.print("");
        }
        System.out.println(this.getName());

    }
}
