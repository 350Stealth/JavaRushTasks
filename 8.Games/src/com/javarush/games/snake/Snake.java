package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;
    
    public Snake(int x, int y) {
        for (int i = 0; i < 3; i++) {
            snakeParts.add(new GameObject(x, y));
            x++;
        }
    }
    
    public void draw(Game game) {
        Color snakeColor;
        if (isAlive) {
            snakeColor = Color.BLACK;
        } else {
            snakeColor = Color.RED;
        }
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject item = snakeParts.get(i);
            if (i == 0) {
                game.setCellValueEx(item.x, item.y, Color.NONE, HEAD_SIGN, snakeColor, 75);
            } else {
                game.setCellValueEx(item.x, item.y, Color.NONE, BODY_SIGN, snakeColor, 75);
            }
        }
    }
    
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void move() {
        GameObject newHead = createNewHead();
        if ((newHead.x >= 0) && (newHead.x < SnakeGame.WIDTH) && (newHead.y >= 0) && (newHead.y < SnakeGame.HEIGHT)) {
            snakeParts.add(0, newHead);
            removeTail();
        } else {
            isAlive = false;
        }
    }
    
    public GameObject createNewHead() {
        int headX = snakeParts.get(0).x;
        int headY = snakeParts.get(0).y;
        switch (direction) {
            case UP:
                return new GameObject(headX, headY - 1);
            case DOWN:
                return new GameObject(headX, headY + 1);
            case LEFT:
                return new GameObject(headX - 1, headY);
            case RIGHT:
                return new GameObject(headX + 1, headY);
        }
        return null;
    }
    
    public void removeTail() {
        snakeParts.remove(snakeParts.size() - 1);
    }
}
