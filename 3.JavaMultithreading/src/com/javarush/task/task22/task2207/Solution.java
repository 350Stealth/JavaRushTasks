package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        String fileName = scanner.nextLine();
        scanner.close();

//        Set<String> stringSet = new HashSet<>();
        List<String> stringList = new LinkedList<>();
        scanner = new Scanner(new FileReader(fileName));
        while (scanner.hasNext()) {
            stringList.add(scanner.next());
        }
        scanner.close();
        
       /* Set<String> bufSet = new HashSet<>();
        for (String line: stringSet) {
            String revLine = new StringBuilder(line).reverse().toString();
            if (stringSet.contains(revLine) && !bufSet.contains(line)) {
                Pair newPair = new Pair();
                newPair.setFirst(line);
                newPair.setSecond(revLine);
                result.add(newPair);
                bufSet.add(revLine);
            }
        }*/
        
        /*while (!stringList.isEmpty()) {
            String line = stringList.listIterator().next();
            stringList.remove(line);
            String revLine = new StringBuilder(line).reverse().toString();
            if (stringList.contains(revLine)) {
                Pair newPair = new Pair();
                newPair.setFirst(line);
                newPair.setSecond(revLine);
                result.add(newPair);
            }
        }*/
        
        String[] strings = stringList.toArray(new String[0]);
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings.length; j++) {
                if (i != j & strings[i] != null & strings[j] != null & (strings[i] != null && strings[i].equals(strings[j]))) {
                    Pair pair = new Pair();
                    pair.setFirst(strings[i]);
                    pair.setSecond(strings[j]);
                    result.add(pair);
                    System.out.println(pair);
                    strings[i] = null;
                    strings[j] = null;
                } else if (i != j & strings[i] != null & strings[j] != null) {
                    StringBuilder strBuilder = new StringBuilder(strings[i]);
                    if (strBuilder.reverse().toString().equals(strings[j])) {
                        Pair pair = new Pair();
                        pair.setFirst(strings[i]);
                        pair.setSecond(strings[j]);
                        result.add(pair);
                        System.out.println(pair);
                        strings[i] = null;
                        strings[j] = null;
                    }
                }
            }
        }
        
        //------------
        for (Pair item: result) {
            System.out.println(item);
        }
        //------------
    }
    
    public static class Pair {
        String first;
        String second;
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            
            Pair pair = (Pair) o;
            
            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;
            
        }
        
        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }
        
        @Override
        public String toString() {
            return first == null && second == null ? "" :
                first == null ? second :
                    second == null ? first :
                        first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
            
        }
        
        public Pair() {
        }
        
        public String getFirst() {
            return first;
        }
        
        public void setFirst(String first) {
            this.first = first;
        }
        
        public String getSecond() {
            return second;
        }
        
        public void setSecond(String second) {
            this.second = second;
        }
    }
    
}
