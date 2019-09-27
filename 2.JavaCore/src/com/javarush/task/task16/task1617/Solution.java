package com.javarush.task.task16.task1617;

/* 
Отсчет на гонках
*/

public class Solution {
    public static volatile int numSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
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
                while (!currentThread().isInterrupted() || numSeconds >= 0){
                    if (numSeconds == 0) {
                        System.out.println("Марш!");
                        break;
                    } else {
                        System.out.println(numSeconds);
                        currentThread().sleep(1000);
                    }
                    numSeconds--;
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
