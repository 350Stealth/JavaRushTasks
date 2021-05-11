package com.javarush.task.task24.task2413;

public class Canvas {
    private int width, height;
    private char[][] matrix;
    
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        matrix = new char[height + 2][width + 2];
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public char[][] getMatrix() {
        return matrix;
    }
    
    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
    
    public void setPoint(double x, double y, char c) {
        if (!(x < 0 || y < 0 || x >= matrix[0].length || y >= matrix.length)) {
            int roundX = (int) Math.round(x);
            int roundY = (int) Math.round(y);
            matrix[roundY][roundX] = c;
        }
    }
    
    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int h = matrix.length;
        int w = matrix[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (matrix[i][j] != 0) {
                    setPoint(x + j, y + i, c);
                }
            }
        }
    }
    
    public void clear() {
        setMatrix(new char[height + 2][width + 2]);
    }
    
    public void print() {
        for (int i = 0; i < height + 2; i++) {
            for (int j = 0; j < width + 2; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
