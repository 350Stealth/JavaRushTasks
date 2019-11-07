package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception{
        
        // for deleting
        args = new String[]{"e:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1821\\in.txt"};
        //////////////////////
    
        FileInputStream inputStream = new FileInputStream(args[0]);
        Scanner scanner = new Scanner(inputStream);
        Map<Character, Integer> map = new HashMap<>();
        while (scanner.hasNext()) {
            Byte character = scanner.nextByte();
            
        }
    }
}
