package com.javarush.task.task22.task2209;

public class Word {
    
    private String word;
    private String firstLetter = "";
    private String lastLetter = "";
    
    public Word(String word) {
        this.word = word;
        if (word != null && word.length() >= 1) {
            firstLetter = word.substring(0, 1);
            lastLetter = word.substring(word.length() - 1);
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
    
    public int isMatch(Word first, Word second) {
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
}
