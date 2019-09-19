package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне0", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне1", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне2", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне3", dateFormat.parse("MARCH 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("JULY 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("JUNE 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("MAY 1 2012"));
        
        //напишите тут ваш код
        
        return map;
    }
    
    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Map<String, Date> bufMap = new HashMap<>();
    
        bufMap.putAll(map);
        
        for (Map.Entry<String, Date> pair : bufMap.entrySet()
        ) {
            if ((pair.getValue().getMonth() >= 5) && (pair.getValue().getMonth() <= 7))
                map.remove(pair.getKey());
        }
    }
    
    public static void main(String[] args) throws ParseException {
        /*
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        
        Date date = dateFormat.parse("JUNE 1 2012");
        
        System.out.println(date.getMonth());
        
        Map<String, Date> myMap = createMap();
        
        for (Map.Entry<String, Date> pair : myMap.entrySet()
        ) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
        
        System.out.println();
        
        removeAllSummerPeople(myMap);
        for (Map.Entry<String, Date> pair : myMap.entrySet()
        ) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }*/
    }
}
