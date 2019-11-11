package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    
    public static void main(String[] args) throws Exception {
        
        // for deleting
        args = new String[]{"e:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1821\\in.txt"};
//        args = new String[]{"d:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1821\\in.txt"};
        //////////////////////
        
        FileReader reader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(reader);
        Map<Character, Integer> map = new HashMap<>();
        int buff = bufferedReader.read();
        if (buff != -1) {
            map.put((char) buff, 1);
        }
        while (buff != -1) {
            if (map.containsKey((char) buff)) {
                int count = map.get(buff);
                count++;
                map.put((char) buff, count);
            } else {
                map.put((char) buff, 1);
            }
            buff = bufferedReader.read();
        }
        bufferedReader.close();
        reader.close();
        
        for (Map.Entry<Character, Integer> item : map.entrySet()
        ) {
            System.out.printf("%c - %d", item.getKey(), item.getValue());
            System.out.println();
        }
    }
}
