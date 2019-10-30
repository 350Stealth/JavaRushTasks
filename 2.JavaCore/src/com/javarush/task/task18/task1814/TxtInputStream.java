package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {
    private FileInputStream content;
    
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        String ext = fileName.substring(fileName.length() - 4).toLowerCase();
        if (ext.equals(".txt")) {
            content = new FileInputStream(fileName);
        } else {
            super.close();
            throw new UnsupportedFileNameException();
        }
    }
    
    public static void main(String[] args) {
    }
}

