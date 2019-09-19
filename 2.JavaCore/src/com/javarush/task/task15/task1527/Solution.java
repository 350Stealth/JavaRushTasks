package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String giveMeURL = scanner.nextLine();
        String giveMeParams = giveMeURL.substring(giveMeURL.indexOf("?"));
        scanner.close();
        System.out.println(giveMeURL); //should be removed
        System.out.println(giveMeParams); //should be removed
        String[] params = giveMeParams.split("&");
        System.out.println(params.toString());
    }
    
    public static void alert(double value) {
        System.out.println("double: " + value);
    }
    
    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
