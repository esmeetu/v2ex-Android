package com.firefly.v2ex.threadpool;

import java.util.concurrent.Future;

/**
 * Created by jason on 9/5/17.
 */

public class CancelTask {

    public void cancelTask() {
        Future future = DefaultExecutorSupplier.getsInstance().getmForBackgroudTasks()
                .submit(new Runnable() {
                    @Override
                    public void run() {
                        // do some background work here.
                    }
                });

        future.cancel(true);
    }
}
