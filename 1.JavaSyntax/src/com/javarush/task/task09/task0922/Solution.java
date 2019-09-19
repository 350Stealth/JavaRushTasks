package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("MMM dd', yyyy");
        
        try {
            Date date = dateFormatIn.parse(s);
        } catch (ParseException pe) {
            System.out.println(pe.getClass().getSimpleName());
        }
        
        
    }
}
