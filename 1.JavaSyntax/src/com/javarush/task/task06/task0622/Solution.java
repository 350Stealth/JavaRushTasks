package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int[] nums = new int[5];
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(reader.readLine());
        }
        
        //напишите тут ваш код
        /*nums = */sortNums(nums);
        
        printNums(nums);
    }
    
    public static void/*int[]*/ sortNums(int[] nums) {
        int buf = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]){
                    buf = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = buf;
                }
            }
        }
//        return nums;
    }
    
    public static void printNums(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
