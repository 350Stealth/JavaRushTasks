package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < 20; i++) {
            if (!set.add(((int) (50 * Math.random()))))
                i--;
        }
        return set;
    }
    
    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Set<Integer> bufSet = new HashSet<>();
        
        for (Integer buf : set
        ) {
            if (buf > 10) bufSet.add(buf);
        }
        
        set.removeAll(bufSet);
        
        return set;
    }
    
    public static void main(String[] args) {
    
    }
}
