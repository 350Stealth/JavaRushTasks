package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class SnakeGame extends Game {
    
    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private Snake snake;
    private int turnDelay;
    
    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    
    private void createGame() {
        snake = new Snake(WIDTH / 2, HEIGHT / 2);
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);
/*
        Apple newApple = new Apple(7, 7 );
        newApple.draw(this);
*/
    
    }
    
    private void drawScene() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
    }
    
    @Override
    public void onTurn(int step) {
//        super.onTurn(step);
        snake.move();
        drawScene();
    }
    
    @Override
    public void onKeyPress(Key key) {
//        super.onKeyPress(key);
        switch (key) {
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
        }
    }
}
