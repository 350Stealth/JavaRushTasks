package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
*/

public class Solution implements List {
    private ArrayList<Long> original = new ArrayList<Long>();

    public static void main(String[] args) {

    }
    
    @Override
    public synchronized int size() {
        return original.size();
    }
    
    @Override
    public synchronized boolean isEmpty() {
        return original.isEmpty();
    }
    
    @Override
    public synchronized boolean contains(Object o) {
        return original.contains(o);
    }
    
    @Override
    public synchronized Iterator iterator() {
        return original.iterator();
    }
    
    @Override
    public synchronized Object[] toArray() {
        return original.toArray();
    }
    
    @Override
    public synchronized Object[] toArray(Object[] a) {
        return /*new Object[0]*/ original.toArray(a);
    }
    
    @Override
    public synchronized boolean add(Object o) {
        return original.add((Long) o);
    }
    
    @Override
    public synchronized boolean remove(Object o) {
        return /*false*/ original.remove(o);
    }
    
    @Override
    public synchronized boolean containsAll(Collection c) {
        return /*false*/ original.containsAll(c);
    }
    
    @Override
    public synchronized boolean addAll(Collection c) {
        return /*false*/ original.addAll(c);
    }
    
    @Override
    public synchronized boolean addAll(int index, Collection c) {
        return /*false*/ original.addAll(index, c);
    }
    
    @Override
    public synchronized boolean removeAll(Collection c) {
        return false;
    }
    
    @Override
    public synchronized boolean retainAll(Collection c) {
        return false;
    }
    
    @Override
    public synchronized void clear() {
    
    }
    
    @Override
    public synchronized Object get(int index) {
        return null;
    }
    
    @Override
    public synchronized Object set(int index, Object element) {
        return null;
    }
    
    @Override
    public synchronized void add(int index, Object element) {
    
    }
    
    @Override
    public synchronized Object remove(int index) {
        return null;
    }
    
    @Override
    public synchronized int indexOf(Object o) {
        return 0;
    }
    
    @Override
    public synchronized int lastIndexOf(Object o) {
        return 0;
    }
    
    @Override
    public synchronized ListIterator listIterator() {
        return null;
    }
    
    @Override
    public synchronized ListIterator listIterator(int index) {
        return null;
    }
    
    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        return null;
    }
}
