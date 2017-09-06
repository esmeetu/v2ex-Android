package com.firefly.v2ex.threadpool;

/**
 * Created by jason on 9/5/17.
 */

public class PrioriyRunnable implements Runnable {

    private final Priority priority;

    public PrioriyRunnable(Priority priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        // nothing to do here.
    }

    public Priority getPriority() {
        return priority;
    }
}
