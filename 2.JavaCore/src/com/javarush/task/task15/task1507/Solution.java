package com.javarush.task.task15.task1507;

/* 
ООП - Перегрузка
*/

import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }
//1
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
//2
    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
//3
    public static void printMatrix(int m, int n, int value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
//4
    public static void printMatrix(int m, int n, double value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
//5
    public static void printMatrix(int m, int n, boolean value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
//6
    public static void printMatrix(int m, int n, float value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
//7
    public static void printMatrix(int m, int n, short value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
//8
    public static void printMatrix(int m, int n, byte value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
//9
    public static void printMatrix(int m, int n, char value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
//10
    public static void printMatrix(int m, int n, Set<Integer> value) {
        System.out.println(m);
        System.out.println(n);
        System.out.println(value);
    }
}
