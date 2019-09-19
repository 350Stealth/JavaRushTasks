package com.javarush.task.task04.task0441;

/* 
Как-то средненько
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int count = 3;
        int[] nums = new int[count];
        
        for (int i = 0; i < count; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        
        int buf;
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    buf = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = buf;
                }
            }
        }
        
        System.out.println(nums[1]);
    }
}
