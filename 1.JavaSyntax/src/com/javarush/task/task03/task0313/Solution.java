package com.javarush.task.task03.task0313;

/* 
Мама мыла раму
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String
            s1 = "Мама",
            s2 = "Мыла",
            s3 = "Раму";
    
        printString(s1, s2, s3);
        printString(s1, s3, s2);
        printString(s2, s1, s3);
        printString(s2, s3, s1);
        printString(s3, s1, s2);
        printString(s3, s2, s1);
    }
    
    public static void printString (String a, String b, String c){
        System.out.println(a + b + c);
    }
}
