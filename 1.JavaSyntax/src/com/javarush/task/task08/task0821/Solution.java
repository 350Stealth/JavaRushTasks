package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> result = new HashMap<>();
        
        String firstName;
        String lastName;
    
        for (int i = 0; i < 10; i++) {
            lastName = "Ivanov" /*+ i*/;
            firstName = "Ivan";
            result.put(lastName, firstName);
        }
        /*
        lastName = "Ivanov" + 0;
    
        for (int i = 0; i < 10; i++) {
            firstName = "Ivan" + i;
            result.put(lastName, firstName);
        }*/

        return result;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
