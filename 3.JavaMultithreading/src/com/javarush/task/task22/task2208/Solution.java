package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
    
    }
    
    public static String getQuery(Map<String, String> params) {
        int count = params.size();
        StringBuilder whereRequest = new StringBuilder();
        for (Map.Entry<String, String> item: params.entrySet()) {
            if (item.getValue() != null) {
                String part = String.format("%s = '%s'", item.getKey(), item.getValue());
                if (!whereRequest.toString().equals("")) {
                    whereRequest.append(" and ");
                }
                whereRequest.append(part);
            }
        }
        return whereRequest.toString();
    }
}
