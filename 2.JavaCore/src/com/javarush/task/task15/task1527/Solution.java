package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
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
        String giveMeParams /*= giveMeURL.substring(giveMeURL.indexOf("?"))*/;
        scanner.close();
//        System.out.println(giveMeURL); //should be removed
//        System.out.println(giveMeParams); //should be removed
        String[] params /*= giveMeParams.split("&")*/;
//        System.out.println(params.toString());
        URL aURL = null;
        try {
            aURL = new URL(giveMeURL);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
//        System.out.println(aURL.getQuery());
        giveMeParams = aURL.getQuery();
        params = giveMeParams.split("&");
        ArrayList<String[]> kyesAndValues = new ArrayList<>();
        for (String s: params
             ) {
//            System.out.print(s + " ");
            kyesAndValues.add(s.split("="));
        }
        System.out.println();
        boolean flag = false;
        for (String[] strings: kyesAndValues
             ) {
            System.out.print(strings[0] + " ");
            if (strings[0].contains("obj")){
                flag = true;
            }
        }
        
        System.out.println();
        
        if (flag) {
            for (String[] strings : kyesAndValues
            ) {
                if (strings.length > 1) {
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
