package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) {
                break;
            }
            list.add(s);
        }
        
        String[] array = list.toArray(new String[0]);
        sort(array);
        
        for (String x : array) {
            System.out.println(x);
        }
    }
    
    public static void sort(String[] array) {
        // напишите тут ваш код
        boolean[] numFlags = new boolean[array.length];
        
        ArrayList<Integer> nums = new ArrayList<>(array.length);
        ArrayList<String> strings = new ArrayList<>(array.length);
        
        for (int i = 0; i < array.length; i++) {
            numFlags[i] = isNumber(array[i]);
            if (numFlags[i]) {
//                numFlags[i] = true;
                nums.add(Integer.parseInt(array[i]));
            } else {
//                numFlags[i] = false;
                strings.add(array[i]);
            }
        }
        
        String[] stringsArray = strings.toArray(new String[0]);//new String[strings.size()]; //(String[]) strings.toArray();
        
/*
        int count = 0;
        for (String item: strings
             ) {
            stringsArray[count] = item;
            count++;
        }
*/
        
        Integer[] numsArray = nums.toArray(new Integer[0]);//(Double[]) nums.toArray();
        
        if (numsArray.length > 1) { // проверяем, что в массиве есть числа
            Arrays.sort(numsArray); // сортируем массив
            int leng = numsArray.length;
            Integer[] numsArrayTemp = Arrays.copyOf(numsArray, leng); //делаем копию исходного массива

//        переворачиваем массив
            for (int i = 0; i < leng; i++) {
                numsArray[i] = numsArrayTemp[leng - 1 - i];
            }
        }
        
//        обрабатываем строки
        String tempString;
        if (stringsArray.length > 1) { // проверяем, что в массиве есть строки
            int leng = stringsArray.length;
            for (int i = 0; i < leng; i++) {
                for (int j = 1; j < leng; j++) {
                    if (isGreaterThan(stringsArray[j - 1], stringsArray[j])) {
                        tempString = stringsArray[j];
                        stringsArray[j] = stringsArray[j - 1];
                        stringsArray[j - 1] = tempString;
                    }
                }
            }
        }
        
//        заполняем исходный массив
        int numCount = 0,
            strCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (numFlags[i]) {
                array[i] = numsArray[numCount].toString();
                numCount++;
            } else {
                array[i] = stringsArray[strCount];
                strCount++;
            }
        }
    }
    
    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
    
    
    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) {
            return false;
        }
        
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // Строка содержит '-'
                || (!Character.isDigit(c) && c != '-') // или не цифра и не начинается с '-'
                || (chars.length == 1 && c == '-')) // или одиночный '-'
            {
                return false;
            }
        }
        return true;
    }
}
