package com.javarush.task.task08.task0822;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }
    
    public static int getMinimum(List<Integer> array) {
        // Найти минимум тут
        int min = array.iterator().next().intValue();
        
        for (Integer num : array
        ) {
            min = (num.intValue() < min ? num.intValue() : min);
        }
        return min;
    }
    
    public static List<Integer> getIntegerList() throws IOException {
        // Создать и заполнить список тут
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();
        
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < numCount; i++) {
            list.add(scanner.nextInt());
        }
        
        return list;
    }
}
