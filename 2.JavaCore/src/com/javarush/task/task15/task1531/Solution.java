package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
        
        if (input >= 0 && input <= 150) {
            System.out.println(factorial(input));
        } else if (input < 0) {
            System.out.println(0);
        }
    }

    public static String factorial(int n) {
        //add your code here
        String s;
        BigDecimal bigNum = new BigDecimal(n);
        if (n == 1 || n == 0) {
            return "1";
        } else {
            bigNum = bigNum.multiply(new BigDecimal(factorial(n-1)));
            s = bigNum.toString();
        }

        return s;
    }
}
