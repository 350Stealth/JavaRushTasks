package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
            {'f', 'd', 'e', 'r', 'l', 'k'},
            {'u', 's', 'a', 'm', 'e', 'o'},
            {'l', 'n', 'g', 'r', 'o', 'v'},
            {'m', 'l', 'p', 'r', 'r', 'h'},
            {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        for (int i = 0; i < crossword.length; i++) {
            int[] intLine = new int[crossword[0].length];
            for (int j = 0; j < crossword[0].length; j++) {
                System.out.print(Character.toChars(crossword[i][j])[0] + ", ");
                intLine[j] = crossword[i][j];
            }
            System.out.println(getString(intLine));
        }
    }
    
    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        Word testWord = new Word(words[0]);
        testWord.setStartPoint(1,1);
        testWord.setEndPoint(2,2);
        System.out.println(testWord);
        return null;
    }
    
    public static List<Word> findHorizontal(int[][] crossword, String word) {
        List<Word> result = new ArrayList<>();
        for (int i = 0; i < crossword.length; i++) {
            int[] intLine = new int[crossword[0].length];
            for (int j = 0; j < crossword[0].length; j++) {
                intLine[j] = crossword[i][j];
                
            }
            String lineToTest = getString(intLine);
            Word newWord = wordMatch(lineToTest, word);
            if (newWord != null) result.add(newWord);
        }
        
        return result;
    }
    
    public static List<Word> findVertical(int[][] crossword, String word) {
        
        return null;
    }
    
    public static List<Word> findDiagonal(int[][] crossword, String word) {
        
        return null;
    }
    
    public static String getString(int[] crossLine) {
        String line;
        char[] charArray = new char[crossLine.length];
        for (int i = 0; i < crossLine.length; i++) {
            charArray[i] = Character.toChars(crossLine[i])[0];
        }
        line = String.valueOf(charArray);
        return line;
    }
    
    public static Word wordMatch(String line, String testWord) {
        
        return null;
    }
    
    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;
        
        public Word(String text) {
            this.text = text;
        }
        
        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }
        
        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }
        
        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
