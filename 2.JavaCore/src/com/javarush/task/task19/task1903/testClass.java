package com.javarush.task.task19.task1903;

public class testClass {
    public static void main(String[] args) {
        int number = 501234567;
        String strNum = Integer.toString(number);
        String gsmCode = strNum.substring(0, 2);
        String nums1 = strNum.substring(2, 5);
        String nums2 = strNum.substring(5, 7);
        String nums3 = strNum.substring(7);
    
        System.out.println(String.format("(0%s)%s-%s-%s", gsmCode, nums1, nums2, nums3));
    }
}
