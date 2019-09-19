package com.javarush.task.task14.task1421;

public class Singleton {
    private static boolean flag = true;
    private static Singleton singleton = null;
    
    public Singleton() {
        if (flag) {
            flag = false;
            singleton = new Singleton();
        } else {
        
        }
    }
}
