package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    
    private List<Horse> horses;
    static Hippodrome game;
    
    public static void main(String[] args) throws InterruptedException {
        
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("HorseOne", 3, 0));
        game.getHorses().add(new Horse("HorseTwo", 3, 0));
        game.getHorses().add(new Horse("HorseThree", 3, 0));
        
        game.run();
        game.printWinner();
    }
    
    public List<Horse> getHorses() {
        return horses;
    }
    
    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }
    
    public void move() {
        for (Horse horse: horses) {
            horse.move();
        }
    }
    
    public void print() {
        for (Horse horse: horses) {
            horse.print();
        }
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
    
    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    
    public Horse getWinner(){
        Horse winner = null;
        for (Horse horse: horses) {
            if (winner == null) {
                winner = horse;
                continue;
            }
            if (winner.getDistance() < horse.getDistance()) {
                winner = horse;
            }
        }
        return winner;
    }
    
    public void printWinner(){
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }
}
