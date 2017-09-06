package com.firefly.v2ex.countdown;

/**
 * Created by jason on 9/6/17.
 */

public class Clock {

    public void doTimer() {
        CountDownSingleton cdInstance = CountDownSingleton.getInstance();
        cdInstance.setTimerListener(new TimerListener() {
            @Override
            public void getTimer(CountDownSingleton cdInstance) {
            }
        });
    }
}
