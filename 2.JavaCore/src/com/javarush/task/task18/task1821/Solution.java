package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        
        FileReader reader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Map<Integer, Integer> map = new TreeMap<>();
        int buff = bufferedReader.read();
        while (buff != -1) {
            Integer count = map.putIfAbsent(buff, 1);
            if (count != null) {
                count++;
                map.put(buff, count);
            }
            buff = bufferedReader.read();
        }
        bufferedReader.close();
        reader.close();
        
        for (Map.Entry<Integer, Integer> item : map.entrySet()
        ) {
            System.out.println(Character.toChars(item.getKey())[0] + " " + item.getValue());
        }
    }
}
