package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        Thread.State state;
        for (Thread item: threads) {
            state = item.getState();
            switch (state) {
                case NEW:
                    item.start();
                    break;
                case RUNNABLE:
                    item.isInterrupted();
                    break;
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    item.interrupt();
                    break;
                case TERMINATED:
                    System.out.println(item.getPriority());
            }
        }
    }

    public static void main(String[] args) {
    }
}
