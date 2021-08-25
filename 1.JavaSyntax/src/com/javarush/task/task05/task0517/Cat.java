package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    String name;
    int age;
    int weight;
    String address;
    String color;
    
    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Red";
    }
    
    public Cat(String name){
        this(name, 12);
    }
    
    public Cat(String name, int age){
        this(name, 12, age);
    }
    
    public Cat(int weight, String color){
        this.age = 5;
        this.weight = weight;
        this.color = color;
    }
    
    public Cat(int weight, String color, String address){
        this(weight, color);
        this.address = address;
    }

    public static void main(String[] args) {
    
    }
}
