package com.javarush.task.task15.task1527;

import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        //add your code here
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String giveMeURL = scanner.nextLine();
        String giveMeParams;
        scanner.close();

        String[] params;
        URL aURL = null;
        try {
            aURL = new URL(giveMeURL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        giveMeParams = aURL.getQuery();
        params = giveMeParams.split("&");
        ArrayList<String[]> kyesAndValues = new ArrayList<>();
        for (String s : params
        ) {
            kyesAndValues.add(s.split("="));
        }
        System.out.println();
        boolean flag = false;
        for (String[] strings : kyesAndValues
        ) {
            System.out.print(strings[0] + " ");
            if (strings[0].contains("obj")) {
                flag = true;
            }
        }
        
        System.out.println();
        
        if (flag) {
            for (String[] strings : kyesAndValues
            ) {
                if (strings.length > 1 && strings[0].contains("obj")) {
                    try {
                        double d = Double.parseDouble(strings[1]);
                        alert(d);
                    } catch (Exception e) {
                        alert(strings[1]);
                    }
                }
            }
        }
    }
    
    public static void alert(double value) {
        System.out.println("double: " + value);
    }
    
    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
