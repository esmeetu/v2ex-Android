package com.firefly.v2ex.threadpool;

/**
 * Created by jason on 9/5/17.
 */

public class UsingThreadPool {

    public void doSomeBackgroundWork() {
        DefaultExecutorSupplier.getsInstance().getmForBackgroudTasks()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        // do some background work here.
                    }
                });
    }

    public void doSomeLightWeightBackgroundWork() {
        DefaultExecutorSupplier.getsInstance().getmForLightWeightBackgroundTasks()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        // do some light-weight background work here.
                    }
                });
    }

    public void doSomeMainThreadWork() {
        DefaultExecutorSupplier.getsInstance().getmMainThreadExecutor()
                .execute(new Runnable() {
                    @Override
                    public void run() {
                        // do some Main Thread work here.
                    }
                });
    }

    public void doSomeTaskAtHightPriority() {
        DefaultExecutorSupplier.getsInstance().getmPriorityThreadExecutor()
                .submit(new PrioriyRunnable(Priority.HIGH) {
                    @Override
                    public void run() {
                        // do some background work here at high priority.
                    }
                });
    }


}
