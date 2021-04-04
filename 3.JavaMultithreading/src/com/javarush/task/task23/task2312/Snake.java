package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    
    public Snake(int x, int y) {
        isAlive = true;
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
    }
    
    private SnakeDirection direction;
    
    public SnakeDirection getDirection() {
        return direction;
    }
    
    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
    
    public List<SnakeSection> getSections() {
        return sections;
    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public int getX() {
        return sections.get(0).getX();
    }
    
    public int getY() {
        return sections.get(0).getY();
    }
    
    public void move() {
        
    }
}
