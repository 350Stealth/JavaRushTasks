package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        detectAllWords(crossword, "home", "same", "ll", "m", "rr", "vor", "re", "ran", "er").forEach(System.out::println);
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
        for (int[] ints : crossword) {
            int[] intLine = new int[crossword[0].length];
            for (int j = 0; j < crossword[0].length; j++) {
                System.out.print(Character.toChars(ints[j])[0] + ", ");
                intLine[j] = ints[j];
            }
            System.out.println(getString(intLine));
        }
    }
    
    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        
        if (crossword == null) return null; // check array for empty
        
        Set<Word> setResult = new HashSet<>();
        for (String word: words) {
            // check lines
            setResult.addAll(findHorizontal(crossword, word));
            // check rows
            setResult.addAll(findVertical(crossword, word));
            // check straight diagonals
            setResult.addAll(findDiagonalStright(crossword, word));
            // check cross diagonals
            setResult.addAll(findDiagonalCross(crossword, word));
        }
        
        System.out.println();
        // output for all elements of List<Word>
        return new ArrayList<>(setResult);
    }
    
    public static List<Word> findHorizontal(int[][] crossword, String word) {
        List<Word> result = new ArrayList<>();
        int lineLength = crossword[0].length;
        int rowLength = crossword.length;
        for (int i = 0; i < rowLength; i++) {
            int[] intLine = new int[lineLength];
            int[] intLineRev = new int[lineLength];
            for (int j = 0; j < lineLength; j++) {
                intLine[j] = crossword[i][j];
                intLineRev[lineLength - (j + 1)] = crossword[i][j];
            }
            String lineToTest = getString(intLine);
//            System.out.println(lineToTest);             // for delete
            String lineToTestReverse = getString(intLineRev);
//            System.out.println(lineToTestReverse);      // for delete
            
            // make lists of matches and correcting coordinates
            List<Word> newWords = wordMatch(lineToTest, word);
            List<Word> newWordsRev = wordMatch(lineToTestReverse, word);
            if (newWords.size() != 0) {
                for (Word w: newWords) {
                    int wStartPoint = w.startX;
                    int wEndPoint = w.endX;
                    w.setStartPoint(wStartPoint, i);
                    w.setEndPoint(wEndPoint, i);
                }
                result.addAll(newWords);
            }
            if (newWordsRev.size() != 0) {
                for (Word w: newWordsRev) {
                    int wStartPoint = lineLength - (w.startX + 1);
                    int wEndPoint = lineLength - (w.endX + 1);
                    w.setStartPoint(wStartPoint, i);
                    w.setEndPoint(wEndPoint, i);
                }
                result.addAll(newWordsRev);
            }
        }
        
        return result;
    }
    
    public static List<Word> findVertical(int[][] crossword, String word) {
        List<Word> result = new ArrayList<>();
        int lineLength = crossword[0].length;
        int rowLength = crossword.length;
        for (int i = 0; i < lineLength; i++) {
            int[] intLine = new int[rowLength];
            int[] intLineRev = new int[rowLength];
            for (int j = 0; j < rowLength; j++) {
                intLine[j] = crossword[j][i];
                intLineRev[rowLength - (j + 1)] = crossword[j][i];
            }
            String lineToTest = getString(intLine);
//            System.out.println(lineToTest);             // for delete
            String lineToTestReverse = getString(intLineRev);
//            System.out.println(lineToTestReverse);      // for delete
            
            // make lists of matches and correcting coordinates
            List<Word> newWords = wordMatch(lineToTest, word);
            List<Word> newWordsRev = wordMatch(lineToTestReverse, word);
            if (newWords.size() != 0) {
                for (Word w: newWords) {
                    int wStartPoint = w.startY;
                    int wEndPoint = w.endY;
                    w.setStartPoint(i, wStartPoint);
                    w.setEndPoint(i, wEndPoint);
                }
                result.addAll(newWords);
            }
            if (newWordsRev.size() != 0) {
                for (Word w: newWordsRev) {
                    int wStartPoint = rowLength - (w.startY + 1);
                    int wEndPoint = rowLength - (w.endY + 1);
                    w.setStartPoint(i, wStartPoint);
                    w.setEndPoint(i, wEndPoint);
                }
                result.addAll(newWordsRev);
            }
        }
        
        return result;
    }
    
    public static List<Word> findDiagonalStright(int[][] crossword, String word) {
        List<Word> result = new ArrayList<>();
        int lineLength = crossword[0].length;
        int rowLength = crossword.length;
        boolean flag = false;
        int counter = 0;
        do {
            if (!flag) {        // upcount tru row
                int i = rowLength - (counter + 1); //row counter
                int j = 0; // line counter
                List<Integer> buff = new ArrayList<>();
            
                while (i < rowLength && j < lineLength) {
                    buff.add(crossword[i][j]);
                    i++;
                    j++;
                }
            
                int stringLength = buff.size() - 1;
                int[] intLine = new int[buff.size()];
                int[] intLineRev = new int[buff.size()];
                for (int k = 0; k < buff.size(); k++) {
                    intLine[k] = buff.get(k);
                    intLineRev[(intLineRev.length - 1) - k] = buff.get(k);
                }
            
                List<Word> newWords = new ArrayList<>(wordMatch(getString(intLine), word));
                if (newWords.size() != 0) {
                    int xShift = 0;
                    int yShift = rowLength - (counter + 1);
                    for (Word w : newWords) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint(xShift + wStartPoint, yShift + wStartPoint);
                        w.setEndPoint(xShift + wEndPoint, yShift + wEndPoint);
                    }
                    result.addAll(newWords);
                }
            
                List<Word> newWordsRev = new ArrayList<>(wordMatch(getString(intLineRev), word));
                if (newWordsRev.size() != 0) {
                    int yShift = rowLength - (counter + 1) + stringLength;
                    for (Word w : newWordsRev) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint(stringLength - wStartPoint, yShift - wStartPoint);
                        w.setEndPoint(stringLength - wEndPoint, yShift - wEndPoint);
                    }
                    result.addAll(newWordsRev);
                }
            
                if (rowLength - (counter + 1) <= 0) {
                    flag = true;
                    counter = 1;
                }
            }
        
            if (flag) {      // count tru line
                int i = 0;
                int j = counter;
                List<Integer> buff = new ArrayList<>();
            
                while (i < rowLength && j < lineLength) {
                    buff.add(crossword[i][j]);
                    i++;
                    j++;
                }
            
                int stringLength = buff.size() - 1;
                int[] intLine = new int[buff.size()];
                int[] intLineRev = new int[buff.size()];
                for (int k = 0; k < buff.size(); k++) {
                    intLine[k] = buff.get(k);
                    intLineRev[(intLineRev.length - 1) - k] = buff.get(k);
                }
            
                List<Word> newWords = new ArrayList<>(wordMatch(getString(intLine), word));
                if (newWords.size() != 0) {
                    for (Word w : newWords) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint(wStartPoint + counter, wStartPoint);
                        w.setEndPoint(wEndPoint + counter, wEndPoint);
                    }
                    result.addAll(newWords);
                }
            
                List<Word> newWordsRev = new ArrayList<>(wordMatch(getString(intLineRev), word));
                if (newWordsRev.size() != 0) {
                    for (Word w : newWordsRev) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint((stringLength + counter) - wStartPoint, stringLength - wStartPoint);
                        w.setEndPoint((stringLength + counter) - wEndPoint, stringLength - wEndPoint);
                    }
                    result.addAll(newWordsRev);
                }
            
            }
            counter++;
        } while (!flag || (counter != lineLength));
        return result;
    }
    
    public static List<Word> findDiagonalCross(int[][] crossword, String word) {
        List<Word> result = new ArrayList<>();
        int lineLength = crossword[0].length;
        int rowLength = crossword.length;
        boolean flag = false;
        int counter = 0;
        do {
            if (!flag) {        // count tru line
                int i = 0; //row counter
                int j = counter; // line counter
                List<Integer> buff = new ArrayList<>();
            
                while (i < rowLength && j >= 0) {
                    buff.add(crossword[i][j]);
                    i++;
                    j--;
                }
            
                int stringLength = buff.size() - 1;
                int[] intLine = new int[buff.size()];
                int[] intLineRev = new int[buff.size()];
                for (int k = 0; k < buff.size(); k++) {
                    intLine[k] = buff.get(k);
                    intLineRev[(intLineRev.length - 1) - k] = buff.get(k);
                }
            
                List<Word> newWords = new ArrayList<>(wordMatch(getString(intLine), word));
                if (newWords.size() != 0) {
                    for (Word w : newWords) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint(counter - wStartPoint, wStartPoint);
                        w.setEndPoint(counter - wEndPoint, wEndPoint);
                    }
                    result.addAll(newWords);
                }
            
                List<Word> newWordsRev = new ArrayList<>(wordMatch(getString(intLineRev), word));
                if (newWordsRev.size() != 0) {
                    int xShift = counter - stringLength;
                    for (Word w : newWordsRev) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint(xShift + wStartPoint, stringLength - wStartPoint);
                        w.setEndPoint(xShift + wEndPoint, stringLength - wEndPoint);
                    }
                    result.addAll(newWordsRev);
                }
            
                if (lineLength - (counter + 1) <= 0) {
                    flag = true;
                    counter = 1;
                }
            }
        
            if (flag) {      // count tru line
                int i = counter; //row counter
                int j = lineLength - 1; // line counter
                List<Integer> buff = new ArrayList<>();
            
                while (i < rowLength && j >= 0) {
                    buff.add(crossword[i][j]);
                    i++;
                    j--;
                }
            
                int stringLength = buff.size() - 1;
                int[] intLine = new int[buff.size()];
                int[] intLineRev = new int[buff.size()];
                for (int k = 0; k < buff.size(); k++) {
                    intLine[k] = buff.get(k);
                    intLineRev[(intLineRev.length - 1) - k] = buff.get(k);
                }
            
                List<Word> newWords = new ArrayList<>(wordMatch(getString(intLine), word));
                if (newWords.size() != 0) {
                    for (Word w : newWords) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint(lineLength - 1 - wStartPoint, counter + wStartPoint);
                        w.setEndPoint(lineLength - 1 - wEndPoint, counter + wEndPoint);
                    }
                    result.addAll(newWords);
                }
            
                List<Word> newWordsRev = new ArrayList<>(wordMatch(getString(intLineRev), word));
                if (newWordsRev.size() != 0) {
                    int xShift = lineLength - (stringLength + 1);
                    int yShift = counter + stringLength;
                    for (Word w : newWordsRev) {
                        int wStartPoint = w.startY;
                        int wEndPoint = w.endY;
                        w.setStartPoint(xShift + wStartPoint, yShift - wStartPoint);
                        w.setEndPoint(xShift + wEndPoint, yShift - wEndPoint);
                    }
                    result.addAll(newWordsRev);
                }
            
            }
            counter++;
        } while (!flag || (counter != lineLength));
        return result;
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
    
    public static List<Word> wordMatch(String line, String testWord) {
        List<Word> result = new ArrayList<>();
        if (line.length() < testWord.length()) return result;
        Pattern pattern = Pattern.compile(testWord);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {

            Word word = new Word(testWord);
            word.setStartPoint(matcher.start(), matcher.start());
            word.setEndPoint(matcher.end() - 1, matcher.end() - 1);
            
            result.add(word);
        }
        return result;
    }
    
    public static class Word {
        private final String text;
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
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Word word = (Word) o;
            
            if (startX != word.startX) return false;
            if (startY != word.startY) return false;
            if (endX != word.endX) return false;
            if (endY != word.endY) return false;
            return text.equals(word.text);
        }
        
        @Override
        public int hashCode() {
            int result = text.hashCode();
            result = 31 * result + startX;
            result = 31 * result + startY;
            result = 31 * result + endX;
            result = 31 * result + endY;
            return result;
        }
    }
}
