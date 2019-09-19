package com.javarush.task.task08.task0817;

import java.util.*;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static Map<String, String> createMap() {
        //напишите тут ваш код
        
        Map<String, String> map = new HashMap<>();
        
        map.put("Иванов0", "Иван");
        map.put("Иванов1", "Сергей");
        map.put("Иванов2", "Василий");
        map.put("Иванов3", "Иван");
        map.put("Иванов4", "Иван");
        map.put("Иванов5", "Иван");
        map.put("Иванов6", "Павел");
        map.put("Иванов7", "Сергей");
        map.put("Иванов8", "Дмитрий");
        map.put("Иванов9", "Александр");
        
        return map;
        
    }
    
    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        
        Set<String> set = new HashSet<>();
        String buff;
        
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            
            Map.Entry<String, String> test = iterator.next();
            buff = test.getValue();
            
            for (Map.Entry<String, String> pair : map.entrySet()
            ) {
                if (pair.getValue().equals(buff) && (!pair.getKey().equals(test.getKey())))
                    set.add(pair.getValue());
            }
        }
        
        for (String key : set
        ) {
            removeItemFromMapByValue(map, key);
        }
    }
    
    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        Map<String, String> copy = new HashMap<>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
            }
        }
    }
    
    public static void main(String[] args) {
        /*
        Map<String, String> myMap = createMap();
        
        for (Map.Entry<String, String> pair : myMap.entrySet()
        ) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
        
        System.out.println();
        
        removeTheFirstNameDuplicates(myMap);
        
        for (Map.Entry<String, String> pair : myMap.entrySet()
        ) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
        */
    }
}
