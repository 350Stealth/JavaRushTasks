package com.javarush.task.task24.task2413;

public abstract class BaseObject {
    protected double x, y, radius;
    
    public double getX() {
        return x;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getY() {
        return y;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getRadius() {
        return radius;
    }
    
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public boolean isIntersec(BaseObject o) {
        double dist = Math.hypot(this.getX() - o.getX(), this.getY() - o.getY());
        return dist <= Math.max(this.getRadius(), o.getRadius());
    }
    
    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    public abstract void draw(Canvas canvas);
    
    public abstract void move();
}
