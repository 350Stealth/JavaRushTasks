package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread implements Runnable {
    private Thread targetThread;
    private State state;
    
    public LoggingStateThread(Thread target) {
        super(target);
        this.targetThread = target;
    }
    
    @Override
    public void run() {
        state = targetThread.getState();
        System.out.println(state);
        while (true) {
            if (state != targetThread.getState()) {
                state = targetThread.getState();
                System.out.println(state.name());
            }
            if (state.equals(State.TERMINATED)) {
                return;
            }
        }
    }
}
