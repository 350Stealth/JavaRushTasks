package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception{
        BufferedReader consolReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn_1 = consolReader.readLine();
        String fileIn_2 = consolReader.readLine();
        consolReader.close();
    
        FileReader fileReader_1 = new FileReader(new File(fileIn_1));
        FileReader fileReader_2 = new FileReader(new File(fileIn_2));
        
        fileReader_2.close();
        fileReader_1.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
