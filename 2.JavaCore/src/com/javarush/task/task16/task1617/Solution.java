package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
        Thread.sleep(100);
        if (clock.isAlive()){
//            clock.interrupt();
            System.out.println("Прервано!");
        }
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            try {
                while (!currentThread().isInterrupted()){
                    if (numSeconds == 0) {
                        System.out.println("Марш!");
                    } else {
                        System.out.println(numSeconds);
                    }
                    numSeconds--;
                    currentThread().sleep(1000);
                }
            } catch (InterruptedException e) {
//                System.out.println("Прервано!");
            }
        }
    }
}
