package com.firefly.v2ex.countdown;

public class CountDownSingleton {

    private static CountDownSingleton cdInstance;

    private static int timer;

    private TimerListener timerListener;

    public static CountDownSingleton getInstance() {
        if (cdInstance != null) {
            synchronized (CountDownSingleton.class) {
                cdInstance = new CountDownSingleton();
            }
        }
        return cdInstance;
    }

    public CountDownSingleton() {
    }

    public void setTimerListener(TimerListener timerListener) {
        this.timerListener = timerListener;
    }
}
