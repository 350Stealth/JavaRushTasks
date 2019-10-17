package com.javarush.task.task17.task1713;

import java.util.*;

/* 
Общий список
*/

public class Solution implements List<Long> {
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
    public synchronized boolean add(Long o) {
        return original.add(o);
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
        return /*false*/ original.removeAll(c);
    }
    
    @Override
    public synchronized boolean retainAll(Collection c) {
        return /*false*/ original.retainAll(c);
    }
    
    @Override
    public synchronized void clear() {
        original.clear();
    }
    
    @Override
    public synchronized Long get(int index) {
        return /*null*/ original.get(index);
    }
    
    @Override
    public synchronized Long set(int index, Long element) {
        return /*null*/ original.set(index, element);
    }
    
    @Override
    public synchronized void add(int index, Long element) {
        original.add(index, element);
    }
    
    @Override
    public synchronized Long remove(int index) {
        return /*null*/ original.remove(index);
    }
    
    @Override
    public synchronized int indexOf(Object o) {
        return original.indexOf(o);
    }
    
    @Override
    public synchronized int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }
    
    @Override
    public synchronized ListIterator listIterator() {
        return /*null*/ original.listIterator();
    }
    
    @Override
    public synchronized ListIterator listIterator(int index) {
        return /*null*/ original.listIterator(index);
    }
    
    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        return /*null*/ original.subList(fromIndex, toIndex);
    }
}
