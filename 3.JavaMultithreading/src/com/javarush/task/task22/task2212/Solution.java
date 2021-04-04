package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null) {
            return false;
        }
        Pattern pattern = Pattern.compile("(\\+\\d{2})?(\\(?\\d{3}\\)?\\d{3}-?\\d{2}-?\\d{2})");
        Matcher matcher = pattern.matcher(telNumber);
        return matcher.matches();
    }

    public static void main(String[] args) {
/*        System.out.println(checkTelNumber("+380501234567")? "Pass" : "Fail");
        System.out.println(checkTelNumber("+38(050)1234567") ? "Pass" : "Fail");
        System.out.println(checkTelNumber("+38050123-45-67") ? "Pass" : "Fail");
        System.out.println(checkTelNumber("050123-4567") ? "Pass" : "Fail");
        System.out.println(checkTelNumber("+38)050(1234567") ? "Fail" : "Pass");
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7") ? "Fail" : "Pass");
        System.out.println(checkTelNumber("050ххх4567") ? "Fail" : "Pass");
        System.out.println(checkTelNumber("050123456") ? "Fail" : "Pass");
        System.out.println(checkTelNumber("(0)501234567") ? "Fail" : "Pass");*/
    }
}
