package com.javarush.task.task22.task2209;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Word {
    
    private String word;
    private String firstLetter = "";
    private String lastLetter = "";
    
    public Word(String word) {
        this.word = word;
        if (word != null && word.length() >= 1) {
            firstLetter = word.substring(0, 1).toLowerCase();
            lastLetter = word.substring(word.length() - 1).toLowerCase();
        }
    }
    
    public String getWord() {
        return word;
    }
    
    public String getFirstLetter() {
        return firstLetter;
    }
    
    public String getLastLetter() {
        return lastLetter;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Word word1 = (Word) o;
        
        return word.equals(word1.word);
    }
    
    @Override
    public int hashCode() {
        return word.hashCode();
    }
    
    public static int isMatch(Word first, Word second) {
        // возвращает 1 если последняя буква первого слова совпадает с первой буквой второго слова
        if (first.getLastLetter().equalsIgnoreCase(second.getFirstLetter())) {
            return 1;
        }
        // возвращает 2 если первая буква первого слова совпадает с последней буквой второго слова
        if (first.getFirstLetter().equalsIgnoreCase(second.getLastLetter())) {
            return 2;
        }
        return 0;
    }
    
    // формирует массив с нужной цепочкой слов (последная буква предыдущего совпадает с первой следующего)
    public static String[] makeArrayFromWords (List<Word> wordList) {
        if (wordList.isEmpty()) {
            return null;
        }
        String[] wordsArray = new String[wordList.size()];
        List<Word> words = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            words.add(wordList.get(i));
        }
        Word buffer = words.get(0);
        for (int i = 1; i < words.size(); i++) {
            if (Word.isMatch(buffer, words.get(i)) == 1) {
                wordsArray[i] = words.get(i).getWord();
                buffer = words.get(i);
            } else {
                Collections.shuffle(words);
                buffer = words.get(0);
                i = 0;
            }
        }
        wordsArray[0] = words.get(0).getWord();
        return wordsArray;
    }
}
