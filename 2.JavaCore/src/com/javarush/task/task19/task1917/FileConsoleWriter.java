package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    public static void main(String[] args) {

    }
    
    private FileWriter fileWriter;
    
    public FileConsoleWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }
    
    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        String line = String.valueOf(cbuf, off, len);
        System.out.println(line);
    }
    
    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }
    
    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }
    
    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        String line = String.valueOf(str.toCharArray(), off, len);
        System.out.println(line);
    }
    
    public void write(char[] cbuf) throws IOException {
    
    }
}
