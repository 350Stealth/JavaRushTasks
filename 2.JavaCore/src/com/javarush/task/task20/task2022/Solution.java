package com.javarush.task.task20.task2022;

import java.io.*;

/*
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
//        out.close();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        stream = new FileOutputStream(fileName, true);
        fileName = (String) in.readObject();
//        in.defaultReadObject();
//        in.close();
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        
        //D:\IdeaProjects\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task20\task2022\TestFile.txt
        String testFileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\TestFile.txt";
        Solution sol = new Solution(testFileName);
        sol.writeObject("Test String");
        
        //D:\IdeaProjects\JavaRushTasks\JavaRushTasks\2.JavaCore\src\com\javarush\task\task20\task2022\TestFile2.txt
        String serializeFileName = "D:\\IdeaProjects\\JavaRushTasks\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task20\\task2022\\TestFile2.txt";
        FileOutputStream fileOutput = new FileOutputStream(serializeFileName);
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
//        sol.writeObject(outputStream);
        outputStream.writeObject(sol);
        sol.close();
        outputStream.close();
        fileOutput.close();
        
        FileInputStream fileInputStream = new FileInputStream(serializeFileName);
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        Solution solNew = (Solution) inputStream.readObject();
        solNew.writeObject("Test String 2");
        solNew.close();
        inputStream.close();
        fileInputStream.close();
    }
}
