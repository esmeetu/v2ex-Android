package com.firefly.v2ex.threadpool;

import android.os.Process;
import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * Created by jason on 9/5/17.
 */

public class PriorityThreadFactory implements ThreadFactory {

    private final int mThreadPriority;

    public PriorityThreadFactory(int mThreadPriority) {
        this.mThreadPriority = mThreadPriority;
    }

    @Override
    public Thread newThread(@NonNull final Runnable runnable) {
        Runnable wrapperRunnable = new Runnable() {
            @Override
            public void run() {
                Process.setThreadPriority(mThreadPriority);

                runnable.run();
            }
        };
        return new Thread(wrapperRunnable);
    }
}
