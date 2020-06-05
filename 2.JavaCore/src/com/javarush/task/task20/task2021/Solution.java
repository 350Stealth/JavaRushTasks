package com.javarush.task.task20.task2021;

import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution implements Serializable{
        public SubSolution() {
        }
        
        public void readObject(ObjectInputStream inputStream) throws NotSerializableException{
            throw new NotSerializableException();
        }
        
        public void writeObject(ObjectOutputStream outputStream) throws NotSerializableException{
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) {

    }
}
