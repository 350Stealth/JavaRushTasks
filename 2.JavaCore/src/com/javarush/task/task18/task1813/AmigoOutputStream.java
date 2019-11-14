package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream component;
    
    public AmigoOutputStream(FileOutputStream component) throws FileNotFoundException {
        super(fileName);
        this.component = component;
    }
    
    @Override
    public void close() throws IOException {
        this.component.flush();
        byte[] buff = "JavaRush © All rights reserved.".getBytes();
        this.component.write(buff);
        component.close();
    }
    
    @Override
    public void write(int b) throws IOException {
        component.write(b);
    }
    
    @Override
    public void write(byte[] b) throws IOException {
        component.write(b);
    }
    
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        component.write(b, off, len);
    }
    
    @Override
    public void flush() throws IOException {
        component.flush();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }
    

}