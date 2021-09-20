package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread implements Runnable{
    private Thread targetThread;
    private Thread.State state;
    
    public LoggingStateThread(Runnable target) {
        super(target);
        this.targetThread = (Thread) target;
    }
    
    @Override
    public void run() {
        state = targetThread.getState();
        System.out.println(state.name());
        while (true) {
            if (state != targetThread.getState()) {
                state = targetThread.getState();
                System.out.println(state.name());
            }
            if (state == State.TERMINATED) {
                return;
            }
        }
    }
}
