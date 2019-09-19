package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а','б','в','г','д','е','ё','ж',
                'з','и','й','к','л','м','н','о',
                'п','р','с','т','у','ф','х','ц',
                'ч','ш','щ','ъ','ы','ь','э','ю','я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        // напишите тут ваш код
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (Character item: alphabet
             ) {
            alphabetMap.put(item, 0);
        }
        
        String fullString = "";
        for (String item: list
             ) {
            fullString += item;
        }
    
//        System.out.println(fullString);
        
        char[] chars = fullString.toCharArray();
    
        for (int i = 0; i < chars.length; i++) {
            if (alphabetMap.containsKey(chars[i])){
                int count = alphabetMap.get(chars[i]);
                count++;
                alphabetMap.put(chars[i], count);
            }
        }
    
//        for (Map.Entry<Character, Integer> item: alphabetMap.entrySet()
//             ) {
//            System.out.println(item.getKey() + " " + item.getValue());
//        }
    
        for (int i = 0; i < alphabet.size(); i++) {
            System.out.println(alphabet.get(i) + " " + alphabetMap.get(alphabet.get(i)));
        }
    }
}
