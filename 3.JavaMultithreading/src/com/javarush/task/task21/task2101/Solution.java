package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[4];
//        System.arraycopy(ip, 0, result, 0, ip.length);
        return result;
    }

    public static void print(byte[] bytes) {
        int i = 0;
        System.out.printf("%d.%d.%d.%d", bytes[++i], bytes[++i] + 256, bytes[++i] + 256, bytes[i] + 256);
        System.out.println();
        for(int num : bytes) {
            String line = "";
            for (int j = 0; j < 8; j++) {
                int rest = num % 2;
                num = num >> 1;
                if (rest == 1) {
                    line += "1";
                } else {
                    line += "0";
                }
            }
            System.out.println(line);
        }
    }
}
