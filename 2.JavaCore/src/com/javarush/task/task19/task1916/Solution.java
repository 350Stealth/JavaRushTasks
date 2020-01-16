package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader consolReader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn_1 = consolReader.readLine();
        String fileIn_2 = consolReader.readLine();
        consolReader.close();
    
        FileReader fileReader_1 = new FileReader(fileIn_1);
        FileReader fileReader_2 = new FileReader(fileIn_2);
        BufferedReader reader_1 = new BufferedReader(fileReader_1);
        BufferedReader reader_2 = new BufferedReader(fileReader_2);
    
        List<String> linesFromFF = new ArrayList<>();
        List<String> linesFromSF = new ArrayList<>();
    
        while (reader_1.ready()) {
            String sLine = reader_1.readLine();
            if (!sLine.isEmpty()) linesFromFF.add(sLine);
        }
    
        while (reader_2.ready()) {
            String sLine = reader_2.readLine();
            if (!sLine.isEmpty()) linesFromSF.add(sLine);
        }
        reader_1.close();
        reader_2.close();
    
        int i = 0;
        int j = 0;
    
        boolean flag1 = false;
        boolean flag2 = false;
    
        while (linesFromFF.size() > 0 && linesFromSF.size() > 0) {
            if (i == linesFromFF.size()) {
                flag1 = true;
                i--;
            }
            if (j == linesFromSF.size()) {
                flag2 = true;
                j--;
            }
            if (linesFromFF.get(i).equals(linesFromSF.get(j))) {
                lines.add(new LineItem(Type.SAME, linesFromFF.get(i)));
                i++;
                j++;
                continue;
            } else if ((i + 1) < linesFromFF.size() && linesFromFF.get(i + 1).equals(linesFromSF.get(j))) {
                lines.add(new LineItem(Type.REMOVED, linesFromFF.get(i)));
                i++;
                continue;
            } else if ((j + 1) < linesFromSF.size() && linesFromSF.get(j + 1).equals(linesFromFF.get(i))) {
                lines.add(new LineItem(Type.ADDED, linesFromSF.get(j)));
                j++;
                continue;
            } else if (flag2 && !flag1) {
                lines.add(new LineItem(Type.REMOVED, linesFromFF.get(i)));
                i++;
                continue;
            } else if (flag1 && !flag2) {
                lines.add(new LineItem(Type.ADDED, linesFromSF.get(j)));
                j++;
                continue;
            }
            break;
        }
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
