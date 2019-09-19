package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        String tmp;
        int sum = 0;
        
        while (true) {
//            tmp = reader.readLine();
            tmp = sc.nextLine();
            if (tmp.equals("сумма"))
                break;
            sum = sum + Integer.parseInt(tmp);
        }
        
        System.out.println(sum);
    }
}
