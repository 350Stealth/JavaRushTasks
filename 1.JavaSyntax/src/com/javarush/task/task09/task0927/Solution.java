package com.javarush.task.task09.task0927;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        /*Cat cat01 = new Cat("Cat01");
        Cat cat02 = new Cat("Cat02");
        Cat cat03 = new Cat("Cat03");
        Cat cat04 = new Cat("Cat04");
        Cat cat05 = new Cat("Cat05");
        Cat cat06 = new Cat("Cat06");
        Cat cat07 = new Cat("Cat07");
        Cat cat08 = new Cat("Cat08");
        Cat cat09 = new Cat("Cat09");
        Cat cat10 = new Cat("Cat10");
        */
        int n = 10;
        Cat[] cats = new Cat[n];
        Map<String, Cat> catsMap = new HashMap<>();
    
        for (int i = 0; i < n; i++) {
            String name = "Cat" + i;
            cats[i] = new Cat(name);
            catsMap.put(name, cats[i]);
        }
        
        return catsMap;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        Set<Cat> catSet = new HashSet<>();
    
        for (Map.Entry<String, Cat> item: map.entrySet()
             ) {
            catSet.add(item.getValue());
        }
        
        return catSet;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
