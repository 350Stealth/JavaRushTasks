package com.javarush.task.task18.task1825;

public class Numbers {
    public static void main(String[] args) {
        int[] word = new int[]{3, 29, 23, 16, 5, 10}; //выходи
        int count = 64;
        for (int i = 32; i < count; i++) {
            String biNum = Integer.toBinaryString(i);
            System.out.println(biNum);
            int sum = 0;
            for (int j = 0; j < word.length - 1; j++) {
                if (biNum.charAt(j) == '1') {
                    sum = sum + word[j];
                } else {
                    sum = sum - word[j];
                }
            }
            if (sum == 22) {
                System.out.println("--" + biNum + "--");
            }
        }
    }
}
