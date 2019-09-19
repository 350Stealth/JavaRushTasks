package com.javarush.task.task08.task0814;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static Set<Integer> createSet() {
        // напишите тут ваш код
        Set<Integer> set = new HashSet<>();
        
        /*Date date = new Date();*/
        
        for (int i = 0; i < 20; i++) {
            if (!set.add(((int) (/*date.getSeconds()*/50 * Math.random()))))
                i--;
        }
        return set;
    }
    
    public static Set<Integer> removeAllNumbersGreaterThan10(Set<Integer> set) {
        // напишите тут ваш код
        Set<Integer> bufSet = new HashSet<>();
        
        for (Integer buf : set
        ) {
            /*if (buf > 10)
                set.remove(buf);*/
            if (buf > 10) bufSet.add(buf);
        }
        
        set.removeAll(bufSet);
        
        return set;
    }
    
    public static void main(String[] args) {
        
        /*Set<Integer> mySet = createSet();
        
        for (Integer buf : mySet
        ) {
            System.out.print(buf + " ");
        }
        System.out.println();
        
        Set<Integer> mySet2 = removeAllNumbersGreaterThan10(mySet);
        
        for (Integer buf : mySet2
        ) {
            System.out.print(buf + " ");
        }*/
        
    }
}
