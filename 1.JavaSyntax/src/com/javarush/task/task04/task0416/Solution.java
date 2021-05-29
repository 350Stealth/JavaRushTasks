package com.javarush.task.task04.task0416;

import java.util.Scanner;

/* 
Переходим дорогу вслепую
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        double time = scanner.nextDouble() % 5;
        scanner.close();
        
        if (time < 3) {
            System.out.println("зелёный");
            return;
        }
        if (time < 4) {
            System.out.println("жёлтый");
            return;
        }
        if (time >= 4) {
            System.out.println("красный");
        }
    }
}