package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // Напишите тут ваши переменные и конструкторы
        private int intVar1;
        private int intVar2;
        private String name1;
        private String name2;
        private boolean logic1;
        private boolean logic2;
    
        public Human(int intVar1) {
            this.intVar1 = intVar1;
        }
    
        public Human(int intVar1, int intVar2) {
            this.intVar1 = intVar1;
            this.intVar2 = intVar2;
        }
    
        public Human(String name1) {
            this.name1 = name1;
        }
    
        public Human(String name1, String name2) {
            this.name1 = name1;
            this.name2 = name2;
        }
    
        public Human(boolean logic1) {
            this.logic1 = logic1;
        }
    
        public Human(boolean logic1, boolean logic2) {
            this.logic1 = logic1;
            this.logic2 = logic2;
        }
    
        public Human(int intVar1, String name1, boolean logic1) {
            this.intVar1 = intVar1;
            this.name1 = name1;
            this.logic1 = logic1;
        }
    
        public Human(int intVar1, int intVar2, String name1) {
            this.intVar1 = intVar1;
            this.intVar2 = intVar2;
            this.name1 = name1;
        }
    
        public Human(int intVar1, int intVar2, String name1, String name2) {
            this.intVar1 = intVar1;
            this.intVar2 = intVar2;
            this.name1 = name1;
            this.name2 = name2;
        }
    
        public Human(int intVar1, int intVar2, String name1, String name2, boolean logic1, boolean logic2) {
            this.intVar1 = intVar1;
            this.intVar2 = intVar2;
            this.name1 = name1;
            this.name2 = name2;
            this.logic1 = logic1;
            this.logic2 = logic2;
        }
    }
}
