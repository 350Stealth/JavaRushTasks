package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {
    
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        SimpleDateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormatOut = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        Date date;
        
        String dateString = new String();
        try {
            dateString = reader.readLine();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
        } finally {
            reader.close();
        }
        
        if (dateString != null)
            try {
                date = dateFormatIn.parse(dateString);
                dateString = dateFormatOut.format(date);
                System.out.println(dateString.toUpperCase());
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName());
            }
    }
}
