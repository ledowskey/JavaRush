package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 01.09.2017.
 */
public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(new ArrayList<>());

        game.getHorses().add(new Horse("Horse1",3, 0));
        game.getHorses().add(new Horse("Horse2",3, 0));
        game.getHorses().add(new Horse("Horse3",3, 0));

//        System.out.println(game.toString());


        game.run();
        game.printWinner();

    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            this.move();
            this.print();
                Thread.sleep(200);
        }
    }
    public void move() {
        for (Horse horse : getHorses()) {
            horse.move();
        }

    }
    public void print() {
        for (Horse horse : getHorses()) {
            horse.print();
        }
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return String.format("Hippodrome: \n" +
                "%s\n", this.getHorses());
    }
    public Horse getWinner() {
        double max = 0;
        Horse winner = null;
        for (Horse horse: getHorses()) {
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println("Winner is " + getWinner().getName() + "!");

    }
}
