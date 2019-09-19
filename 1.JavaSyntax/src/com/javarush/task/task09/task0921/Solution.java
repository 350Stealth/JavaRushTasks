package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
    
        int num = 0;
//        boolean flag = true;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
//                flag = false;
                break;
            }
                list.add(num);
        }
        for (Integer integer: list
             ) {
            System.out.println(integer);
        }
    }
}
