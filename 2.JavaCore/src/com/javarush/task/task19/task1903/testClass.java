package com.javarush.task.task19.task1903;

public class testClass {
    public static void main(String[] args) {
        int number = 1501234567;
        String strNum = Integer.toString(number);
        String gsmCode = strNum.substring(0, 2);
        String nums1 = strNum.substring(2, 5);
        String nums2 = strNum.substring(5, 7);
        String nums3 = strNum.substring(7);
    
        System.out.println(String.format("(0%s)%s-%s-%s", gsmCode, nums1, nums2, nums3));
    
        int phoneCode = 38;
        int phoneNumber = number;
        int phoneGSMCode = phoneNumber / 10000000;
        int numGroup1 = (phoneNumber - phoneGSMCode * 10000000) / 10000;
        int numGroup2 = (phoneNumber - phoneGSMCode * 10000000 - numGroup1 * 10000) / 100;
        int numGroup3 = phoneNumber - phoneGSMCode * 10000000 - numGroup1 * 10000 - numGroup2 * 100;
        System.out.println(String.format("%+d(%03d)%d-%d-%d", phoneCode, phoneGSMCode, numGroup1, numGroup2, numGroup3));
    }
}
