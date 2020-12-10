package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    
    private List<GameObject> snakeParts = new ArrayList<>();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    
    public Snake(int x, int y) {
        for (int i = 0; i < 3; i++) {
            snakeParts.add(new GameObject(x, y));
            x++;
        }
    }
    
    public void draw(Game game) {
        for (int i = 0; i < snakeParts.size(); i++) {
            GameObject item = snakeParts.get(i);
            if (i == 0) {
                game.setCellValue(item.x, item.y, HEAD_SIGN);
            } else {
                game.setCellValue(item.x, item.y, BODY_SIGN);
            }
        }
    }
}
