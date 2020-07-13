package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
            {1, 0, 0, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {1, 0, 0, 1}
        };
    
        System.out.println(a1.length);
        System.out.println(a2.length);
        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }
    
    public static int getRectangleCount(byte[][] a) {
        int posX, posY,
            x = 0,
            y = 0,
            count = 0,
            cell;
        boolean flag = false;
        
        while (true) {
            cell = a[x][y];
            if (cell == 1) {
                count++;
                posX = x;
                posY = y;
                boolean flagX = true,
                    flagY = true;
                while (a[posX][posY] == 1 || (flagX && flagY)) {
                    if (flagX) {
                        if (posX + 1 >= a.length || a[posX + 1][posY] == 0) {
                            flagX = false;
                        } else {
                            posX++;
                        }
                    } else {
                        if (posY + 1 >= a.length || a[posX][posY + 1] == 0) {
                            flagY = false;
                        } else {
                            posY++;
                        }
                    }
                }
                for (int i = x; i < posX; i++) {
                    for (int j = y; j < posY; j++) {
                        a[i][j] = 0;
                    }
                }
            }
            x++;
            if (x >= a.length) {
                x = 0;
                y++;
                if (y >= a.length) flag = true;
            }
            if (flag) break;
        }
        
        return count;
    }
}
