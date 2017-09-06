package com.firefly.v2ex.threadpool;

import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jason on 9/5/17.
 */

public class PriorityThreadPoolExecutor extends ThreadPoolExecutor {

    public PriorityThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, new PriorityBlockingQueue<Runnable>(), threadFactory);
    }

    @Override
    public Future<?> submit(Runnable task) {
        PriorityFutureTask futureTask = new PriorityFutureTask((PrioriyRunnable) task);
        execute(futureTask);
        return futureTask;
    }

    private static final class PriorityFutureTask extends FutureTask<PrioriyRunnable>
            implements Comparable<PriorityFutureTask> {

        private final PrioriyRunnable prioriyRunnable;

        private PriorityFutureTask(PrioriyRunnable prioriyRunnable) {
            super(prioriyRunnable, null);
            this.prioriyRunnable = prioriyRunnable;
        }


        @Override
        public int compareTo(@NonNull PriorityFutureTask priorityFutureTask) {
            Priority p1 = prioriyRunnable.getPriority();
            Priority p2 = priorityFutureTask.prioriyRunnable.getPriority();
            return p2.ordinal() - p1.ordinal();
        }
    }
}
