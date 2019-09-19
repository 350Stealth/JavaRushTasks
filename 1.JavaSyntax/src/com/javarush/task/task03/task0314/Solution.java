package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int
            i = 1,
            j = 1;
        
        while (i <= 10) {
            while (j <= 10) {
                System.out.print((i * j) + " ");
                j++;
            }
            i++;
            j = 1;
            System.out.println();
        }
    }
}
