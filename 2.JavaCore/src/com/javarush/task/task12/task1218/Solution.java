package com.javarush.task.task12.task1218;

/* 
Есть, летать и двигаться
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanMove {
        public void move();
    }

    public interface CanEat {
        public void eat();
    }

    public class Dog implements CanMove, CanEat{
        @Override
        public void move() {
        
        }
    
        @Override
        public void eat() {
        
        }
    }

    public class Duck implements CanEat, CanMove, CanFly{
        @Override
        public void fly() {
        
        }
    
        @Override
        public void move() {
        
        }
    
        @Override
        public void eat() {
        
        }
    }

    public class Car implements CanMove{
        @Override
        public void move() {
        
        }
    }

    public class Airplane implements CanFly, CanMove{
        @Override
        public void fly() {
        
        }
    
        @Override
        public void move() {
        
        }
    }
}
