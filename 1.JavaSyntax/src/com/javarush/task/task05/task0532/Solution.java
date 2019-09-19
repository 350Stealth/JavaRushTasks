package com.javarush.task.task05.task0532;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        int tmp = Integer.parseInt(reader.readLine());
        int buf;
        
        if (n > 1)
            for (int i = 1; i < n; i++) {
                buf = Integer.parseInt(reader.readLine());
                tmp = tmp > buf ? tmp : buf;
            }
        
        int maximum = tmp;
        
        //напишите тут ваш код
        
        System.out.println(maximum);
    }
}
