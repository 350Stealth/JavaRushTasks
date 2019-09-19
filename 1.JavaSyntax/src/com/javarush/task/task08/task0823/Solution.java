package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        
        String n_space = " ",
            result = "";
        
        boolean flag = true;
        
        Character[] characters = new Character[string.length()];
        
        for (int i = 0; i < string.length(); i++) {
            characters[i] = string.toCharArray()[i];
        }
        
        for (int i = 0; i < characters.length; i++) {
            if (flag) {
                characters[i] = Character.toUpperCase(characters[i]);
                flag = false;
            }
            if (characters[i].toString().equals(n_space) && (i < characters.length - 1)) {
                characters[i + 1] = Character.toUpperCase(characters[i + 1]);
            }
            result = result + characters[i];
        }
        
        System.out.println(result);
        
        //напишите тут ваш код
        
    }
}
