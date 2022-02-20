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
        map.put("Смирнов", dateFormat.parse("JANUARY 1 2012"));
        map.put("Смирнов2", dateFormat.parse("FEBRUARY 1 2012"));
        map.put("Смирнов3", dateFormat.parse("MARCH 1 2012"));
        map.put("Смирнов4", dateFormat.parse("APRIL 1 2012"));
        map.put("Смирнов5", dateFormat.parse("MAY 1 2012"));
        map.put("Смирнов6", dateFormat.parse("JUNE 1 2012"));
        map.put("Смирнов7", dateFormat.parse("JULY 1 2012"));
        map.put("Смирнов8", dateFormat.parse("AUGUST 1 2012"));
        map.put("Смирнов9", dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Смирнов10", dateFormat.parse("OCTOBER 1 2012"));

        //напишите тут ваш код
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        //напишите тут ваш код
        Map<String, Date> bufMap = new HashMap<>();
        for (Map.Entry<String, Date> item: map.entrySet()) {
            int buf = item.getValue().getMonth();
            if (buf >= 5 && buf <= 7) {
                bufMap.put(item.getKey(), item.getValue());
            }
        }
        for (Map.Entry<String, Date> item: bufMap.entrySet()) {
            map.remove(item.getKey());
        }
    }

    public static void main(String[] args) {
        Map<String, Date> mapa = new HashMap<>();
        try {
            mapa = createMap();
        } catch (Exception e) {
            e.printStackTrace();
        }
        removeAllSummerPeople(mapa);
        System.out.println(mapa);
    }
}
