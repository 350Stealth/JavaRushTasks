package com.javarush.task.task04.task0402;

/* 
Цена яблок
*/

public class Solution {
    public static void main(String[] args) {
        Apple apple = new Apple();
        apple.addPrice(50);
        Apple apple2 = new Apple();
        apple2.addPrice(100);
//        int price = apple.applesPrice + apple2.applesPrice;
        System.out.println(Apple.objectCount);
        System.out.println("Стоимость яблок " + Apple.applesPrice);
    }

    public static class Apple {
        public static int applesPrice = 0;
        public static int objectCount = 0;

        public static void addPrice(int applesPrice) {
            //напишите тут ваш код
            Apple.applesPrice = Apple.applesPrice + applesPrice;
        }
    
        public Apple() {
            objectCount++;
        }
    }
}
