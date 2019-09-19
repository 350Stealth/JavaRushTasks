package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

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
        map.put("Сталлоне3", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне4", dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Сталлоне5", dateFormat.parse("OCTOBER 1 2012"));
        map.put("Сталлоне6", dateFormat.parse("NOVEMBER 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Сталлоне8", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("FEBRUARY 1 2012"));
        
        //напишите тут ваш код
        return map;
    }
    
    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Map<String, Date> copy = new HashMap<>(map);
        
        Date testDate;
        /*testDate.setYear(0);
        testDate.setDate(0);*/
        
        for (Map.Entry<String, Date> pair : copy.entrySet()
        ) {
            testDate = pair.getValue();
            if ((testDate.getMonth() >= 6) && (testDate.getMonth() <= 8))
                map.remove(pair.getKey());
        }
    }
    
    public static void main(String[] args) throws ParseException {
        
        Map<String, Date> myMap = createMap();
        removeAllSummerPeople(myMap);
        
        for (Map.Entry<String, Date> pair : myMap.entrySet()
        ) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
        
    }
}
