package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        int countArrayMembers = (int) (Math.random()*100) + 1;
        ArrayList<String>[] strings = new ArrayList[countArrayMembers];
        
        for (int i = 0; i < countArrayMembers; i++) {
            int countListMembers = (int) (Math.random()*5) + 1;
            strings[i] = new ArrayList<>();
            for (int j = 0; j < countListMembers; j++) {
                double number = Math.random();
                String s = "" + number;
                strings[i].add(s);
            }
        }
        
        return strings;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}