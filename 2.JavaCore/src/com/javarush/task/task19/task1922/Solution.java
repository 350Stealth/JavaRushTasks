package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
    
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        
        String fileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1922\\in.txt";
        
        
    }
}
